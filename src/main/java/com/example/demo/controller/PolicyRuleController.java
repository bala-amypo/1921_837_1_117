package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public PolicyRule addRule(@RequestBody PolicyRule rule) {
        return service.addRule(rule);
    }

    @GetMapping
    public List<PolicyRule> getAllRules() {
        return service.getAllRules();
    }
}
