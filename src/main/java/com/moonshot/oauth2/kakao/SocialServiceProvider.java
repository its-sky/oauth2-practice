package com.moonshot.oauth2.kakao;

import com.moonshot.oauth2.service.KakaoSocialService;
import com.moonshot.oauth2.service.SocialService;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SocialServiceProvider {

    private static final Map<SocialPlatform, SocialService> socialServiceMap = new HashMap<>();
    private final KakaoSocialService kakaoSocialService;

    @PostConstruct
    void initSocialServiceMap() {
        socialServiceMap.put(SocialPlatform.KAKAO, kakaoSocialService);
    }

    public SocialService getSocialService(SocialPlatform socialPlatform) {
        return socialServiceMap.get(socialPlatform);
    }
}
