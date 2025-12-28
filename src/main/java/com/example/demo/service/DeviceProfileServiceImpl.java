package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        device.setLastSeen(LocalDateTime.now());
        return repo.save(device);
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId);
    }

    @Override
    public List<DeviceProfile> findByUserId(long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public DeviceProfile updateTrustStatus(long id, boolean trusted) {
        DeviceProfile device = repo.findById(id).orElse(null);
        if (device == null) return null;
        device.setTrusted(trusted);
        return repo.save(device);
    }
}
