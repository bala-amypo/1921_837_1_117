package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileRepository repo;

    public DeviceProfileController(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return repo.save(device);
    }

    @PutMapping("/{id}/trust")
    public DeviceProfile updateTrust(@PathVariable Long id,
                                     @RequestParam boolean trust) {

        DeviceProfile d = repo.findById(id).orElseThrow();
        d.setIsTrusted(trust);
        return repo.save(d);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> devicesByUser(@PathVariable Long userId) {
        return repo.findAll()
                   .stream()
                   .filter(d -> d.getUserId().equals(userId))
                   .toList();
    }

    @GetMapping("/lookup/{deviceId}")
    public DeviceProfile findByDevice(@PathVariable String deviceId) {
        return repo.findByDeviceId(deviceId);
    }
}
