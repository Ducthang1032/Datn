package com.poly.datn.be.service;

import com.poly.datn.be.domain.UserEntity;
import com.poly.datn.be.enums.LoginType;
import com.poly.datn.be.model.UserLoginDTO;
import com.poly.datn.be.repository.UserRepository;
import com.poly.datn.be.util.PhoneUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity checkLogin(UserLoginDTO userLogin) {

        List<UserEntity> userList = new ArrayList<>();
        if (userLogin.getLoginType().equalsIgnoreCase(LoginType.EMAIL.getValue()))
            userList = userRepository.findAllByEmailIgnoreCase(StringUtils.lowerCase(userLogin.getUsername()));

        if (userLogin.getLoginType().equalsIgnoreCase(LoginType.PHONE.getValue())) {
            String phone = PhoneUtils.formatPhoneNumber(userLogin.getUsername());
            if (StringUtils.isNotBlank(phone))
                userList = userRepository.findAllByPhone(phone);
        }

        if (CollectionUtils.isEmpty(userList))
            return null;

        return userList.stream().findFirst().orElse(null);
    }
}
