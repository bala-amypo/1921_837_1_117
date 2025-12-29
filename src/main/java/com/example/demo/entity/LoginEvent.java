package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "login_events")
public class LoginEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String loginStatus; // SUCCESS / FAILED
    private Instant eventTime;

    public LoginEvent() {
        this.eventTime = Instant.now();
    }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public Long getUserId(){ return userId; }
    public void setUserId(Long userId){ this.userId = userId; }

    public String getLoginStatus(){ return loginStatus; }
    public void setLoginStatus(String loginStatus){ this.loginStatus = loginStatus; }

    public Instant getEventTime(){ return eventTime; }
    public void setEventTime(Instant eventTime){ this.eventTime = eventTime; }
}
