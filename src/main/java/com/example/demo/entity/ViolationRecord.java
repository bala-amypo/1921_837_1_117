package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "violation_records")
public class ViolationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private Long userId;
    private String violationType;
    private String details;
    private boolean resolved;
    private Long employeeId;

    public ViolationRecord(){}

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public Long getEventId(){ return eventId; }
    public void setEventId(Long eventId){ this.eventId = eventId; }

    public Long getUserId(){ return userId; }
    public void setUserId(Long userId){ this.userId = userId; }

    public String getViolationType(){ return violationType; }
    public void setViolationType(String violationType){ this.violationType = violationType; }

    public String getDetails(){ return details; }
    public void setDetails(String details){ this.details = details; }

    public boolean getResolved(){ return resolved; }
    public void setResolved(boolean resolved){ this.resolved = resolved; }

    public Long getEmployeeId(){ return employeeId; }
    public void setEmployeeId(Long employeeId){ this.employeeId = employeeId; }
}
