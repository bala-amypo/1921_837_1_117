package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

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
