package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repo;
    private final RuleEvaluationUtil ruleUtil;

    // ⚠️ exact constructor order REQUIRED by tests
    public LoginEventServiceImpl(
            LoginEventRepository repo,
            RuleEvaluationUtil ruleUtil) {

        this.repo = repo;
        this.ruleUtil = ruleUtil;
    }

    @Override
    public LoginEvent record(LoginEvent event) {
        LoginEvent saved = repo.save(event);
        ruleUtil.evaluateLoginEvent(saved);
        return saved;
    }

    @Override
    public List<LoginEvent> successByUser(Long userId) {
        return repo.findByUserIdAndLoginStatus(userId, "SUCCESS");
    }

    @Override
    public List<LoginEvent> failedByUser(Long userId) {
        return repo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    @Override
    public List<LoginEvent> getAll() {
        return repo.findAll();
    }
}
