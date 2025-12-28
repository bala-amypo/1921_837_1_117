package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PolicyRule {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String ruleCode;

    private String description;
    private String severity;
    private String conditionsJson;
    private Boolean active = true;

    public Long getId() {
        return id;
    }

    public String getDescription() {   // ✅ REQUIRED
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {   // ✅ REQUIRED
        this.severity = severity;
    }

    public Boolean getActive() {       // ✅ REQUIRED
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
