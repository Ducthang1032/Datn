package com.poly.datn.be.controller;

import com.poly.datn.be.domain.UserEntity;
import com.poly.datn.be.domain.constant.AccountConst;
import com.poly.datn.be.domain.dto.ReqForgotPasswordDto;
import com.poly.datn.be.dto.LoginResponseDTO;
import com.poly.datn.be.dto.MetaDTO;
import com.poly.datn.be.dto.ResponseMetaData;
import com.poly.datn.be.dto.UserRegisterDTO;
import com.poly.datn.be.enums.MetaData;
import com.poly.datn.be.enums.UserStatus;
import com.poly.datn.be.model.UserLoginDTO;
import com.poly.datn.be.service.AESService;
import com.poly.datn.be.service.AuthService;
import com.poly.datn.be.service.UserService;
import com.poly.datn.be.service.ValidationService;
import com.poly.datn.be.util.PhoneUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticateController extends BaseController {

    private final AuthService authService;

    private final UserService userService;

    private final AESService aesService;
    private final ValidationService validationService;


    @PostMapping(AccountConst.API_ACCOUNT_FORGOT_PASSWORD)
    public ResponseEntity<?> forgotPassword(@RequestBody ReqForgotPasswordDto reqForgotPasswordDto) throws MessagingException {
        return new ResponseEntity<>("Mật khẩu mới đã được gửi về mail!", HttpStatus.OK);
    }

    @PostMapping("/login")
    @SneakyThrows
    public ResponseEntity<ResponseMetaData> login(@RequestBody UserLoginDTO userLogin) {
        if (StringUtils.isBlank(userLogin.getUsername()))
            return ResponseEntity.badRequest()
                    .body(new ResponseMetaData(new MetaDTO(MetaData.EMAIL_OR_PHONE_MISSING)));
        log.info("Start login with username: {}", userLogin.getUsername());

        UserEntity userEntity = userService.checkLogin(userLogin);
        if (Objects.isNull(userEntity) || UserStatus.isNotActive(userEntity.getStatus()))
            return ResponseEntity.badRequest()
                    .body(new ResponseMetaData(new MetaDTO(MetaData.USERNAME_OR_PASSWORD_INCORRECT)));

        userLogin.setPassword(aesService.decryptDataWithoutUrl(userLogin.getPassword()));
        //generate access token
        LoginResponseDTO loginResponseDTO = authService.generateToken(userLogin, userEntity, false);
        if (Objects.isNull(loginResponseDTO)) {
            log.info("FAILED login with username: {}", userLogin.getUsername());
            return ResponseEntity.status(MetaData.UNAUTHORIZED.getMetaCode())
                    .body(new ResponseMetaData(new MetaDTO(MetaData.UNAUTHORIZED)));
        }
        log.info("Finish login with username: {}", userLogin.getUsername());
        return ResponseEntity.ok().body(new ResponseMetaData(new MetaDTO(MetaData.SUCCESS), loginResponseDTO));
    }

    @SneakyThrows
    @PostMapping("/register")
    public ResponseEntity<ResponseMetaData> register(@RequestBody UserRegisterDTO registerDTO) {
        registerDTO.setEmail(StringUtils.lowerCase(registerDTO.getEmail()));
        log.info("Start register with email: {}", registerDTO.getEmail());
        ResponseMetaData response = new ResponseMetaData();
        registerDTO.setPassword(aesService.decryptDataWithoutUrl(registerDTO.getPassword()));
        registerDTO.setPhone(PhoneUtils.formatPhoneNumber(registerDTO.getPhone()));

        List<MetaDTO> metaListCheckInput = validationService.validationInputRegister(registerDTO);
        if (!CollectionUtils.isEmpty(metaListCheckInput)) {
            response.setMeta(metaListCheckInput);
            return ResponseEntity.badRequest().body(response);
        }


        LoginResponseDTO loginResponseDTO = authService.saveUserRegisSuccess(registerDTO);
        if (Objects.nonNull(loginResponseDTO)) {
            loginResponseDTO.setAccessToken(loginResponseDTO.getAccessToken());
            response.setMeta(new MetaDTO(MetaData.SUCCESS));
            response.setData(loginResponseDTO);
            return ResponseEntity.ok(response);
        }

        response.setMeta(new MetaDTO(MetaData.SERVICE_UNAVAILABLE));
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }
}
