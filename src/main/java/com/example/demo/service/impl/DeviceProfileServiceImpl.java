package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        device.setTrusted(true);
        return repo.save(device);
    }

    @Override
    public DeviceProfile getByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId).orElse(null);
    }
}
