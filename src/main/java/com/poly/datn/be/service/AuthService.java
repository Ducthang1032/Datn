package com.poly.datn.be.service;

import com.poly.datn.be.config.AuthConfig;
import com.poly.datn.be.constants.AuthoritiesConstants;
import com.poly.datn.be.domain.UserEntity;
import com.poly.datn.be.dto.LoginResponseDTO;
import com.poly.datn.be.dto.UserRegisterDTO;
import com.poly.datn.be.model.UserLoginDTO;
import com.poly.datn.be.repository.UserRepository;
import com.poly.datn.be.security.CustomAuthenticationManager;
import com.poly.datn.be.security.JwtTokenProvider;
import com.poly.datn.be.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final AuthConfig authConfig;
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomAuthenticationManager customAuthenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final AESService aesService;
    private final UserRepository userRepository;

    public LoginResponseDTO generateToken(UserLoginDTO requestModel, UserEntity userEntity, boolean isCreateUser) {
        log.info("Start generate token with username = {}", requestModel.getUsername());
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(AuthoritiesConstants.ROLE_PREFIX.concat(userEntity.getRole()));
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(String.valueOf(userEntity.getId()), requestModel.getPassword(), grantedAuthorities);

        // Authentication manager authenticate the user, and use UserDetailsServiceImpl::loadUserByUsername() method to load the user.
        Authentication auth = customAuthenticationManager.authenticate(authToken);

        if (Objects.isNull(auth)) {
            log.info("Authenticate fail with userEntity: {}", userEntity.getName());
            return null;
        }

        SecurityContextHolder.getContext().setAuthentication(auth);

        Date expirationTime = new Date(System.currentTimeMillis() + authConfig.getExpirationToken());

        String token = jwtTokenProvider.generateToken(auth, expirationTime);

        log.info("Finish generate token with username = {}", requestModel.getUsername());
        return new LoginResponseDTO(token, DateTimeUtil.convertDateToLocalDateTime(expirationTime),
                userEntity, aesService, userEntity.getRole());
    }

    public LoginResponseDTO saveUserRegisSuccess(UserRegisterDTO registerDTO) {
        log.info("Start create new user with email = {}, phone = {}", registerDTO.getEmail(), registerDTO.getPhone());
        UserEntity userEntity = new UserEntity(registerDTO);
        userEntity.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        userRepository.save(userEntity);

        LoginResponseDTO response = generateToken(new UserLoginDTO(registerDTO), userEntity, true);
        log.info("SUCCESS while create new user with userId = {}, email = {}, phone = {}",
                userEntity.getId(), registerDTO.getEmail(), registerDTO.getPhone());
        return response;
    }
}
