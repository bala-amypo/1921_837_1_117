package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;

import java.util.List;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository policyRuleRepository;

    public RuleEvaluationUtil(PolicyRuleRepository policyRuleRepository) {
        this.policyRuleRepository = policyRuleRepository;
    }

    public ViolationRecord evaluate(LoginEvent event) {

        List<PolicyRule> activeRules = policyRuleRepository.findByActiveTrue();

        for (PolicyRule rule : activeRules) {

            if ("FAILED".equalsIgnoreCase(event.getLoginStatus())) {

                ViolationRecord vr = new ViolationRecord();
                vr.setUserId(event.getUserId());
                vr.setRuleId(rule.getId());
                vr.setViolationType("LOGIN_FAILURE");
                vr.setDetails("Failed login detected");
                vr.setResolved(false);

                return vr;
            }
        }

        return null;
    }
}
