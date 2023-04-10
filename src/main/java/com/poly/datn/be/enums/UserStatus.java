package com.poly.datn.be.enums;

import lombok.Getter;

@Getter
public enum UserStatus {
    ACTIVE("active"),
    BLOCKED("blocked"),
    REMOVED("removed");

    private final String value;

    UserStatus(String value) {
        this.value = value;
    }

    public static boolean isNotActive(String status) {
        return !isActive(status);
    }

    public static boolean isActive(String status) {
        return ACTIVE.getValue().equalsIgnoreCase(status);
    }
}
