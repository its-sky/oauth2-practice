package com.moonshot.oauth2.dto.response;

public record SocialLoginResponse(
        Long userId
) {
    public static SocialLoginResponse of(Long userId) {
        return new SocialLoginResponse(userId);
    }
}
