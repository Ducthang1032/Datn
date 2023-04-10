package com.poly.datn.be.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.poly.datn.be.constants.CommonConstant;
import com.poly.datn.be.domain.UserEntity;
import com.poly.datn.be.service.AESService;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
public class LoginResponseDTO {
    @JsonProperty("_id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expire_time")
    private String expireTime;

    @JsonProperty("role")
    private String role;

    @JsonProperty("time_zone")
    private String timeZone;

    public LoginResponseDTO(String accessToken, LocalDateTime expirationTime, UserEntity userEntity,
                            AESService aesService, String role) {
        this.id = aesService.encryptData(userEntity.getId().toString());
        this.accessToken = accessToken;
        this.expireTime = String.valueOf(expirationTime);
        this.name = userEntity.getName();
        this.role = role;
        this.timeZone = String.format(CommonConstant.GMT, ZoneId.systemDefault().getRules().getOffset(Instant.now()).getId());
    }
}
