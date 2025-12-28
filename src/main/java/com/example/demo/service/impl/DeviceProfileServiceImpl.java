package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        device.setTrusted(false);
        return repo.save(device);
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public DeviceProfile trustDevice(long deviceId) {
        DeviceProfile device = repo.findById(deviceId).orElseThrow();
        device.setTrusted(true);
        return repo.save(device);
    }
}
