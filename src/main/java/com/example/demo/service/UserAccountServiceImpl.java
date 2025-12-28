package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    // ⚠️ constructor order MATTERS
    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccount create(UserAccount user) {
        return repo.save(user);
    }

    @Override
    public UserAccount getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<UserAccount> getAll() {
        return repo.findAll();
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        UserAccount u = getById(id);
        u.setStatus(status);
        return repo.save(u);
    }

    @Override
    public UserAccount findByUsername(String username) {
        return repo.findByUsername(username);
    }
}
