package com.example.demo.util;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository policyRuleRepository;
    private final ViolationRecordRepository violationRecordRepository;

    public RuleEvaluationUtil(PolicyRuleRepository policyRuleRepository,
                              ViolationRecordRepository violationRecordRepository) {
        this.policyRuleRepository = policyRuleRepository;
        this.violationRecordRepository = violationRecordRepository;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        for (PolicyRule rule : policyRuleRepository.findByActiveTrue()) {
            if ("FAILED".equals(event.getLoginStatus())) {
                ViolationRecord vr = new ViolationRecord();
                vr.setUserId(event.getUserId());
                vr.setPolicyRuleId(rule.getId());
                vr.setEventId(event.getId());
                vr.setViolationType("LOGIN_FAILURE");
                vr.setSeverity(rule.getSeverity());
                vr.setDetails("Login failed policy triggered");
                violationRecordRepository.save(vr);
            }
        }
    }
}
