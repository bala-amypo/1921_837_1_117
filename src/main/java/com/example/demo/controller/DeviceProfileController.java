package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return service.registerDevice(device);
    }

    @GetMapping("/{deviceId}")
    public DeviceProfile getByDeviceId(@PathVariable String deviceId) {
        return service.getByDeviceId(deviceId);
    }
}
