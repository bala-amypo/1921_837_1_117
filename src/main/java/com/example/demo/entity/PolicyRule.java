package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String conditionsJson;
    private int severity;
    private boolean active;

    public PolicyRule() {}

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleCode() {
        return ruleCode;
    }
    
    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getConditionsJson() {
        return conditionsJson;
    }
    
    public void setConditionsJson(String conditionsJson) {
        this.conditionsJson = conditionsJson;
    }

    public int getSeverity() {
        return severity;
    }
    
    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
}
