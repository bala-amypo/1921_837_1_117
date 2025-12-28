package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    @PostMapping("/record")
    public LoginEvent record(@RequestBody LoginEvent event) {
        return service.recordLogin(event);
    }

    @GetMapping
    public List<LoginEvent> all() {
        return service.getEventsByUser(0);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> byUser(@PathVariable long userId) {
        return service.getEventsByUser(userId);
    }

    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> suspicious(@PathVariable long userId) {
        return service.getSuspiciousLogins(userId);
    }
}
