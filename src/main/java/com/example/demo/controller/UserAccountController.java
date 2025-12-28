package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return service.create(user);
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}/status")
    public UserAccount updateStatus(@PathVariable Long id,
                                    @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return service.getAll();
    }
}
