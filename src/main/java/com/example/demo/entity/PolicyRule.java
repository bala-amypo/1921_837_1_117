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

    public Long getId() { return id; }
    public String getSeverity() { return severity; }
}
