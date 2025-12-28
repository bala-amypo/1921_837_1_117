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
    public UserAccount create(@RequestBody UserAccount user) {
        return service.create(user);
    }

    @GetMapping
    public List<UserAccount> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}/status")
    public UserAccount updateStatus(
            @PathVariable long id,
            @RequestParam String status
    ) {
        return service.updateUserStatus(id, status);
    }
}
