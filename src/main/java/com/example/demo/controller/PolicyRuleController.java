package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    private final PolicyRuleRepository repo;

    public PolicyRuleController(PolicyRuleRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public PolicyRule create(@RequestBody PolicyRule rule) {
        return repo.save(rule);
    }

    @PutMapping("/{id}")
    public PolicyRule update(@PathVariable Long id,
                             @RequestBody PolicyRule rule) {

        PolicyRule existing = repo.findById(id).orElseThrow();
        existing.setDescription(rule.getDescription());
        existing.setSeverity(rule.getSeverity());
        existing.setActive(rule.getActive());
        return repo.save(existing);
    }

    @GetMapping("/active")
    public List<PolicyRule> activeRules() {
        return repo.findByActiveTrue();
    }

    @GetMapping
    public List<PolicyRule> allRules() {
        return repo.findAll();
    }
}
