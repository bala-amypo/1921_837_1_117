package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount user) {
        return ResponseEntity.ok(service.create(user));
    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getById(@PathVariable long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<UserAccount> updateStatus(
            @PathVariable long id,
            @RequestParam String status
    ) {
        return ResponseEntity.ok(service.updateUserStatus(id, status));
    }
}
