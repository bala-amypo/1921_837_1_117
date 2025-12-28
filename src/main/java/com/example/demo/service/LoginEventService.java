package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {

    LoginEvent recordLogin(LoginEvent event);

    List<LoginEvent> getEventsByUser(long userId);

    List<LoginEvent> getSuspiciousLogins(long userId);
}
