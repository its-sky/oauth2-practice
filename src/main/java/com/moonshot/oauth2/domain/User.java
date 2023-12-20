package com.moonshot.oauth2.domain;

import com.moonshot.oauth2.common.domain.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class User extends BaseTimeEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String profileImage;

    @Column(nullable = false)
    private String accessToken;

    @Column(nullable = false)
    private String refreshToken;

    @Column(nullable = false)
    private Long socialId;

    public User(String nickname, String profileImage, String accessToken, String refreshToken, Long socialId) {
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.socialId = socialId;
    }

    public static User of(String nickname, String profileImage, String accessToken, String refreshToken, Long socialId) {
        return new User(nickname, profileImage, accessToken, refreshToken, socialId);
    }
}
