package com.moonshot.oauth2.service;

import com.moonshot.oauth2.domain.User;
import com.moonshot.oauth2.dto.request.SocialLoginRequest;
import com.moonshot.oauth2.dto.response.KakaoAccessTokenResponse;
import com.moonshot.oauth2.dto.response.KakaoUserResponse;
import com.moonshot.oauth2.dto.response.SocialLoginResponse;
import com.moonshot.oauth2.kakao.feign.KakaoApiClient;
import com.moonshot.oauth2.kakao.feign.KakaoAuthApiClient;
import com.moonshot.oauth2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoSocialService extends SocialService {

    @Value("${kakao.client-id}")
    private String clientId;

    @Value("${kakao.redirect-url}")
    private String redirectUrl;

    private final UserRepository userRepository;
    private final KakaoAuthApiClient kakaoAuthApiClient;
    private final KakaoApiClient kakaoApiClient;

    @Override
    public SocialLoginResponse login(SocialLoginRequest request) throws IOException {
        KakaoAccessTokenResponse tokenResponse = kakaoAuthApiClient.getOAuth2AccessToken(
                "authorization_code",
                clientId,
                redirectUrl,
                request.code()
        );

        System.out.println("here for " + tokenResponse.getAccessToken());

        KakaoUserResponse userResponse = kakaoApiClient.getUserInformation(
                "Bearer " + tokenResponse.getAccessToken());

        Optional<User> findUser = userRepository.findUserBySocialId(userResponse.getId());

        User user;
        if (findUser.isEmpty()) {
            User newUser = userRepository.save(User.of(
                    userResponse.getKakaoAccount().getProfile().getNickname(),
                    userResponse.getKakaoAccount().getProfile().getProfileImageUrl(),
                    tokenResponse.getAccessToken(),
                    tokenResponse.getRefreshToken(),
                    userResponse.getId()
            ));

            user = userRepository.findUserBySocialId(userResponse.getId()).get();
        } else {
            user = findUser.get();
        }

        return SocialLoginResponse.of(user.getId());
    }
}
