package com.bearnrabbit.coffeeorder.api.auth.utils;

import com.bearnrabbit.coffeeorder.api.auth.dto.AuthDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TokenProvider {

    private final Key key;

    @Value("${jwt.expiretime.accesstoken}")
    private long ACCESS_TOKEN_EXPIRE;
    @Value("${jwt.expiretime.refreshtoken}")
    private long REFRESH_TOKEN_EXPIRE;

    public TokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }


    public AuthDto.TokenInfo createAccessToken(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));

        long now = new Date().getTime();

        //accessToken generate
        String accessToken = Jwts.builder().setSubject(authentication.getName())
                .claim("auth", authorities).setExpiration(new Date(now + ACCESS_TOKEN_EXPIRE))
                .signWith(key, SignatureAlgorithm.HS256).compact();

        String refreshToken = Jwts.builder().claim("check", authentication.getName())
                .setExpiration(new Date(now + REFRESH_TOKEN_EXPIRE))
                .signWith(key, SignatureAlgorithm.HS256).compact();

        return AuthDto.TokenInfo.builder().grantType("Bearer").accessToken(accessToken)
                .refreshToken(refreshToken).build();
    }

    public AuthDto.TokenInfo createRefreshToken(String accessToken, String refreshToken) {
        Claims refreshTokenClaims = parseClaims(refreshToken);
        String accessTokenName;
        String accessTokenAuthorities;

        try {
            Claims accessTokenClaims = parseClaims(accessToken);
            accessTokenName = accessTokenClaims.getSubject();
            accessTokenAuthorities = accessTokenClaims.get("auth").toString();
        } catch (ExpiredJwtException e) {
            accessTokenName = e.getClaims().getSubject();
            accessTokenAuthorities = e.getClaims().get("auth").toString();
        }

        if (!accessTokenName.equals(refreshTokenClaims.get("check").toString())) {
            log.error("Token Not Match");
            // 예외처리 변수 추후 지정
            throw new RuntimeException("Token Not Match");
        }

        long now = new Date().getTime();
        String newAccessToken = Jwts.builder().setSubject(accessTokenName)
                .claim("auth", accessTokenAuthorities).setExpiration(new Date(now + ACCESS_TOKEN_EXPIRE))
                .signWith(key, SignatureAlgorithm.HS256).compact();
        String newRefreshToken = Jwts.builder().claim("check", accessTokenName)
                .setExpiration(new Date(now + REFRESH_TOKEN_EXPIRE))
                .signWith(key, SignatureAlgorithm.HS256).compact();

        return AuthDto.TokenInfo.builder().grantType("Bearer").accessToken(newAccessToken)
                .refreshToken(newRefreshToken).build();
    }

    public Long getUserId(String token) {
        String userId;
        try {
            Claims claims = parseClaims(token);
            userId = claims.getSubject();
        } catch (ExpiredJwtException e) {
            userId = e.getClaims().getSubject();
        }
        return Long.parseLong(userId);
    }

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public void validateAccessToken(String token) {
        Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }
}
