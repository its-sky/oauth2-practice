package com.moonshot.oauth2.common.exception.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorType {

    /**
     * 400 BAD REQUEST
     */
    BAD_REQUEST_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),


    /**

     * 404 NOT FOUND
     */
    USER_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "일치하는 유저가 없습니다"),

    /**
     * 500 INTERNAL SERVER ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 에러가 발생했습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
