package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {
    LoginEvent record(LoginEvent event);
    List<LoginEvent> successByUser(Long userId);
    List<LoginEvent> failedByUser(Long userId);
    List<LoginEvent> getAll();
}
