package com.example.demo.config;

import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfig {

    @Bean
    public RuleEvaluationUtil ruleEvaluationUtil(
            PolicyRuleRepository policyRuleRepository,
            ViolationRecordRepository violationRecordRepository) {

        return new RuleEvaluationUtil(
                policyRuleRepository,
                violationRecordRepository);
    }
}
