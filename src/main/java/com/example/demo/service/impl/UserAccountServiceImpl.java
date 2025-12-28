package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccount create(UserAccount user) {
        if (user.getUsername() == null) {
            user.setUsername(user.getEmail());
        }
        user.setActive(true);
        return repo.save(user);
    }

    @Override
    public UserAccount getByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public UserAccount getById(long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public UserAccount updateUserStatus(long id, String status) {
        UserAccount user = repo.findById(id).orElseThrow();
        user.setActive("ACTIVE".equalsIgnoreCase(status));
        return repo.save(user);
    }
}
