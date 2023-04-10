package com.poly.datn.be.service;

import com.poly.datn.be.dto.MetaDTO;
import com.poly.datn.be.dto.UserRegisterDTO;
import com.poly.datn.be.enums.MetaData;
import com.poly.datn.be.util.EmailUtils;
import com.poly.datn.be.util.PasswordUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidationService {

    public List<MetaDTO> validationInputRegister(UserRegisterDTO registerDTO) {
        List<MetaDTO> metaList = validationEmailAndPhone(registerDTO.getEmail(), registerDTO.getPhone());

        if (StringUtils.isBlank(registerDTO.getPassword()) || !PasswordUtils.isPassword(registerDTO.getPassword())) {
            log.warn("Param password is invalid");
            metaList.add(new MetaDTO(MetaData.PASSWORD_INVALID));
        }
        return metaList;
    }

    public List<MetaDTO> validationEmailAndPhone(String email, String phone) {
        List<MetaDTO> metaList = new ArrayList<>();

        if (StringUtils.isBlank(phone) && (StringUtils.isBlank(email) || !EmailUtils.isEmail(email))) {
            log.warn("Param email is invalid");
            metaList.add(new MetaDTO(MetaData.EMAIL_OR_PHONE_INVALID));
        }
        return metaList;
    }
}