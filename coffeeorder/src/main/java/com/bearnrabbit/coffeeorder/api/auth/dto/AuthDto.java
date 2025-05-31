package com.bearnrabbit.coffeeorder.api.auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

public class AuthDto {


    //=== request dto ===//

    @Getter
    @Setter
    public static class LoginRequest {
        @Schema(description = "이메일", requiredMode = Schema.RequiredMode.REQUIRED)
        private String email;
        @Schema(description = "패스워드", requiredMode = Schema.RequiredMode.REQUIRED)
        private String password;

    }


    @Getter
    @Setter
    @Schema(description = "로그인 response")
    public static class LoginResponse {
        private String accessToken;
        private String refreshToken;
        private UserDto user;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Schema(description = "로그인 토큰")
    public static class TokenInfo {
        @Schema(hidden = true)
        @JsonIgnore
        private String grantType;
        @Schema(description = "액세스 토큰", requiredMode = Schema.RequiredMode.REQUIRED, example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMCIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE3MzY0MTEyNTZ9.4-u7c0eViu5U6k3-hSvNUkqNubvjiXTINfLH_XgTJws")
        private String accessToken;
        @Schema(hidden = true)
        private Long accessTokenExpiresIn;
        @Schema(hidden = true)
        private String refreshToken;
        @Schema(hidden = true)
        private String expiredMessage;
    }
}
