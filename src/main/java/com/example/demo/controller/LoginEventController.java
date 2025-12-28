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
        return service.record(event);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> successByUser(@PathVariable Long userId) {
        return service.successByUser(userId);
    }

    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> failedByUser(@PathVariable Long userId) {
        return service.failedByUser(userId);
    }

    @GetMapping
    public List<LoginEvent> all() {
        return service.getAll();
    }
}
