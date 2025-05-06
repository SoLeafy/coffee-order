package com.bearnrabbit.coffeeorder.domain.user;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Comment("회원pk")
    private Long userId;

    @Column(name = "name")
    @Comment("회원명")
    private String name;

    @Column(name = "user_name")
    @Comment("회원아이디")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @Column(name = "refresh_token")
    private String refreshToken;
}
