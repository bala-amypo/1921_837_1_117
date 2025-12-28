package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repo;

    public LoginEventServiceImpl(LoginEventRepository repo) {
        this.repo = repo;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        event.setTimestamp(LocalDateTime.now());
        return repo.save(event);
    }

    @Override
    public List<LoginEvent> getEventsByUser(long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(long userId) {
        return repo.findSuspiciousByUserId(userId);
    }
}
