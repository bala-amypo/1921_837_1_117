package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {
    DeviceProfile save(DeviceProfile device);
    DeviceProfile updateTrust(Long id, boolean trust);
    List<DeviceProfile> byUser(Long userId);
    DeviceProfile byDeviceId(String deviceId);
}
