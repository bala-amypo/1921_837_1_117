package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        String token = jwtUtil.generateToken(request.getUsername());
        return new JwtResponse(token);
    }
}
