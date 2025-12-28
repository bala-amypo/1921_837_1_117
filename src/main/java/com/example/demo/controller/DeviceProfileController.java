package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviceProfile> register(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> getByUser(@PathVariable long userId) {
        return ResponseEntity.ok(service.getDevicesByUser(userId));
    }

    @PutMapping("/{deviceId}/trust")
    public ResponseEntity<DeviceProfile> trust(@PathVariable long deviceId) {
        return ResponseEntity.ok(service.trustDevice(deviceId));
    }
}
