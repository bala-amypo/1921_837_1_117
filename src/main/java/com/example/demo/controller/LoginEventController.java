package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventRepository repo;
    private final RuleEvaluationUtil ruleUtil;

    public LoginEventController(LoginEventRepository repo,
                                RuleEvaluationUtil ruleUtil) {
        this.repo = repo;
        this.ruleUtil = ruleUtil;
    }

    @PostMapping("/record")
    public LoginEvent record(@RequestBody LoginEvent event) {
        LoginEvent saved = repo.save(event);
        ruleUtil.evaluateLoginEvent(saved);
        return saved;
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getByUser(@PathVariable Long userId) {
        return repo.findByUserIdAndLoginStatus(userId, "SUCCESS");
    }

    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> suspicious(@PathVariable Long userId) {
        return repo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    @GetMapping
    public List<LoginEvent> all() {
        return repo.findAll();
    }
}
