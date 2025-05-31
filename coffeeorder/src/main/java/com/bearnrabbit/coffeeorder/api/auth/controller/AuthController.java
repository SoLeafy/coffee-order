package com.bearnrabbit.coffeeorder.api.auth.controller;

import com.bearnrabbit.coffeeorder.api.auth.dto.AuthDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    @Tag(name = "Auth")
    @Operation(summary = "로그인")
    @PostMapping("/login")
    public AuthDto.LoginResponse login(AuthDto.LoginRequest request) {

    }
}
