package com.poly.datn.be.controller;

import com.poly.datn.be.constants.AuthoritiesConstants;
import com.poly.datn.be.constants.CommonConstant;
import com.poly.datn.be.util.NumberUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestController
@RequestMapping
public class BaseController {

    @Autowired
    public HttpServletRequest request;

    public Long getUserIdFromToken() {
        return NumberUtil.parseLong(Objects.toString(request
                .getHeader(CommonConstant.USER_ID), StringUtils.EMPTY), 0L);
    }

    public boolean isNotVerifyOtp() {
        String isVerifyOtp = request.getHeader(AuthoritiesConstants.IS_VERIFY_OTP);
        return Strings.isNotBlank(isVerifyOtp) && String.valueOf(false).equalsIgnoreCase(isVerifyOtp);
    }

    public boolean isNotDecryptDeviceId() {
        String isDecryptDeviceId = request.getHeader(AuthoritiesConstants.IS_DECRYPT_DEVICE_ID); //false
        return StringUtils.isNotBlank(isDecryptDeviceId) && !Boolean.parseBoolean(isDecryptDeviceId);
    }
}