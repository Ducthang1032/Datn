package com.poly.datn.be.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum RoleAccount {
    ADMIN(1L, "ADMIN"),
    USER(2L, "USER");

    private final Long roleId;
    private final String name;

    RoleAccount(Long roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }
}