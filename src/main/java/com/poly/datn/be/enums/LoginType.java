package com.poly.datn.be.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum LoginType {
    PHONE("phone"),
    EMAIL("email");

    private final String value;

    LoginType(String value) {
        this.value = value;
    }

    public static boolean loginTypeIsExist(String value) {
        return Arrays.stream(LoginType.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

}
