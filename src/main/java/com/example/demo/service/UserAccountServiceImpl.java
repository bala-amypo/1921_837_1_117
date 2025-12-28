package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

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
}
