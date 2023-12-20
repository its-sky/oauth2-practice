package com.moonshot.oauth2.common.exception.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessType {

    /**
     * 200 OK
     */
    DEFAULT_SUCCESS(HttpStatus.OK, "OK"),
    SOCIAL_LOGIN_SUCCESS(HttpStatus.OK, "소셜 로그인 성공"),

    /**
     * 201 CREATED
     */

    /**
     * 204 NO CONTENT
     */
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
