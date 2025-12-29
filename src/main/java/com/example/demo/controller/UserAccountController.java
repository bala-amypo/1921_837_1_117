package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return service.createUser(user);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable long id) {
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
