package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile save(DeviceProfile device) {
        return repo.save(device);
    }

    @Override
    public DeviceProfile updateTrust(Long id, boolean trust) {
        DeviceProfile d = repo.findById(id).orElseThrow();
        d.setIsTrusted(trust);
        return repo.save(d);
    }

    @Override
    public List<DeviceProfile> byUser(Long userId) {
        return repo.findAll()
                .stream()
                .filter(d -> d.getUserId().equals(userId))
                .toList();
    }

    @Override
    public DeviceProfile byDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId);
    }
}
