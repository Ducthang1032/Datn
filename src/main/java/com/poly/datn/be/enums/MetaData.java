package com.poly.datn.be.enums;

import lombok.Getter;

@Getter
public enum MetaData {
    //Successful responses
    SUCCESS(200, "Success"),
    NO_CONTENT(204, "No Content"),

    //Missing register param
    EMAIL_OR_PHONE_MISSING(411, "Email or phone is missing"),

    // Client error responses
    BAD_REQUEST(400, "Bad request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    ACTION_NOT_ALLOWED(406, "Action Not Allowed"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    TOKEN_EXPIRED(400, "Token expired"),
    ACCESS_DENIED(409, "Access is denied"),
    USERNAME_OR_PASSWORD_INCORRECT(410, "Username or password incorrect"),
    PASSWORD_INVALID(411, "Password invalid"),
    EMAIL_OR_PHONE_INVALID(412, "Email or phone invalid"),

    // Server error responses
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout");

    private final Integer metaCode;
    private final String message;

    MetaData(Integer metaCode, String message) {
        this.metaCode = metaCode;
        this.message = message;
    }

}
