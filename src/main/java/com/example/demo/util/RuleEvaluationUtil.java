package com.example.demo.util;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository policyRuleRepository;
    private final ViolationRecordRepository violationRecordRepository;

    public RuleEvaluationUtil(
            PolicyRuleRepository policyRuleRepository,
            ViolationRecordRepository violationRecordRepository) {

        this.policyRuleRepository = policyRuleRepository;
        this.violationRecordRepository = violationRecordRepository;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        if ("FAILED".equals(event.getLoginStatus())) {
            for (PolicyRule rule : policyRuleRepository.findByActiveTrue()) {
                ViolationRecord vr = new ViolationRecord();
                vr.setViolationType("LOGIN_FAILURE");
                vr.setDetails("Policy rule triggered");
                violationRecordRepository.save(vr);
            }
        }
    }
}
