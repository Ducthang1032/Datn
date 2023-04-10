package com.poly.datn.be.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.poly.datn.be.dto.UserRegisterDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("login_type")
    private String loginType;

    public UserLoginDTO(UserRegisterDTO userRegisterDTO) {
        this.username = userRegisterDTO.getEmail();
        this.password = userRegisterDTO.getPassword();
    }
}
