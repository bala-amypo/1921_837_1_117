package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.LoginEventService;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;
    private final LoginEventService loginEventService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            UserAccountService userService,
            LoginEventService loginEventService,
            JwtUtil jwtUtil,
            PasswordEncoder passwordEncoder
    ) {
        this.userService = userService;
        this.loginEventService = loginEventService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {

        UserAccount user = userService.getByUsername(request.getUsername());

        String status = "FAILED";
        String token = null;

        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            status = "SUCCESS";
            token = jwtUtil.generateToken(
                    user.getUsername(),
                    user.getId(),
                    user.getRole(),
                    user.getEmail()
            );
        }

        LoginEvent event = new LoginEvent();
        event.setUserId(user != null ? user.getId() : null);
        event.setLoginStatus(status);
        loginEventService.recordLogin(event);

        return ResponseEntity.ok(new JwtResponse(token, status));
    }
}
