package com.moonshot.oauth2.service;

import com.moonshot.oauth2.dto.request.SocialLoginRequest;
import com.moonshot.oauth2.dto.response.SocialLoginResponse;
import java.io.IOException;

public abstract class SocialService {
    public abstract SocialLoginResponse login(SocialLoginRequest request) throws IOException;
}
