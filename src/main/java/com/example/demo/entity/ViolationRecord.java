package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long ruleId;

    private String violationType;

    private String details;

    private boolean resolved;

    public ViolationRecord() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    // 🔥 REQUIRED BY TESTS
    public String getViolationType() {
        return violationType;
    }

    // 🔥 REQUIRED BY TESTS
    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    // 🔥 REQUIRED BY TESTS
    public String getDetails() {
        return details;
    }

    // 🔥 REQUIRED BY TESTS
    public void setDetails(String details) {
        this.details = details;
    }

    public boolean getResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
