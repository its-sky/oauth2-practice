package com.moonshot.oauth2.controller;

import com.moonshot.oauth2.common.dto.ApiResponse;
import com.moonshot.oauth2.common.exception.enums.SuccessType;
import com.moonshot.oauth2.dto.request.SocialLoginRequest;
import com.moonshot.oauth2.dto.response.SocialLoginResponse;
import com.moonshot.oauth2.kakao.SocialPlatform;
import com.moonshot.oauth2.kakao.SocialServiceProvider;
import com.moonshot.oauth2.service.SocialService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final SocialServiceProvider socialServiceProvider;

    @GetMapping("/login")
    public ApiResponse<SocialLoginResponse> login(@RequestHeader("Authorization") String authorization) throws IOException {
        SocialService socialService = socialServiceProvider.getSocialService(SocialPlatform.KAKAO);
        return ApiResponse.success(SuccessType.SOCIAL_LOGIN_SUCCESS, socialService.login(SocialLoginRequest.of(authorization)));
    }

    @GetMapping("/login/oauth2/code/kakao")
    public String success(@RequestParam String code) {
        return code;
    }
}
