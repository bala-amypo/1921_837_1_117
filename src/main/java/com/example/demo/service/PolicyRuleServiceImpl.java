package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repo;

    public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public PolicyRule create(PolicyRule rule) {
        return repo.save(rule);
    }

    @Override
    public PolicyRule update(Long id, PolicyRule rule) {
        PolicyRule r = repo.findById(id).orElseThrow();
        r.setDescription(rule.getDescription());
        r.setSeverity(rule.getSeverity());
        r.setActive(rule.getActive());
        return repo.save(r);
    }

    @Override
    public List<PolicyRule> active() {
        return repo.findByActiveTrue();
    }

    @Override
    public List<PolicyRule> all() {
        return repo.findAll();
    }
}
