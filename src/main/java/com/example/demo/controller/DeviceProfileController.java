package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return service.registerDevice(device);
    }

    @GetMapping("/lookup/{deviceId}")
    public DeviceProfile lookup(@PathVariable String deviceId) {
        return service.findByDeviceId(deviceId);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> byUser(@PathVariable long userId) {
        return service.findByUserId(userId);
    }

    @PutMapping("/{id}/trust")
    public DeviceProfile trust(
            @PathVariable long id,
            @RequestParam boolean trusted
    ) {
        return service.updateTrustStatus(id, trusted);
    }
}
