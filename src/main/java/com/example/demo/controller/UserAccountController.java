package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountRepository repo;

    public UserAccountController(UserAccountRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return repo.save(user);
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}/status")
    public UserAccount updateStatus(@PathVariable Long id,
                                    @RequestParam String status) {

        UserAccount user = repo.findById(id).orElseThrow();
        user.setStatus(status);
        return repo.save(user);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }
}
