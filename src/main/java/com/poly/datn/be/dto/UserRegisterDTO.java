package com.poly.datn.be.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.poly.datn.be.constants.EmailConstants;
import com.poly.datn.be.constants.RegexConstants;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
public class UserRegisterDTO {

    @Email(message = EmailConstants.EMAIL_VALIDATION_MESSAGE, regexp = RegexConstants.EMAIL_REGEX)
    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("name")
    private String name;

    @JsonProperty("password")
    private String password;

}
