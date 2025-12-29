package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "device_profiles")
public class DeviceProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;
    private boolean trusted;
    private boolean active;
    private Long userId;

    public DeviceProfile() {}

    public Long getId() { return id; }
    public void setId(Long id){ this.id = id; }

    public String getDeviceId(){ return deviceId; }
    public void setDeviceId(String deviceId){ this.deviceId = deviceId; }

    public boolean getIsTrusted(){ return trusted; }
    public void setIsTrusted(boolean trusted){ this.trusted = trusted; }

    public boolean getActive(){ return active; }
    public void setActive(boolean active){ this.active = active; }

    public Long getUserId(){ return userId; }
    public void setUserId(Long userId){ this.userId = userId; }
}
