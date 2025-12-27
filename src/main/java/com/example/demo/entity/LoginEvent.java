package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class LoginEvent {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Long userId;
private String ipAddress;
private String location;
private String deviceId;
private String loginStatus;
private LocalDateTime timestamp = LocalDateTime.now();
}