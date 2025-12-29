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
    public UserAccount createUser(UserAccount user) {
        user.setActive(true);
        return repo.save(user);
    }

    @Override
    public UserAccount getByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }

    @Override
    public UserAccount getByEmployeeId(String employeeId) {
        return repo.findByEmployeeId(employeeId).orElse(null);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public UserAccount getById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public UserAccount updateUserStatus(long id, String status) {
        UserAccount user = repo.findById(id).orElse(null);
        if (user != null) {
            user.setActive("ACTIVE".equalsIgnoreCase(status));
            repo.save(user);
        }
        return user;
    }
}
