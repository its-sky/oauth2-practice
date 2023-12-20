package com.moonshot.oauth2.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public record SocialLoginRequest(
        String code
) {
    public static SocialLoginRequest of(String code) {
        return new SocialLoginRequest(code);
    }
}
