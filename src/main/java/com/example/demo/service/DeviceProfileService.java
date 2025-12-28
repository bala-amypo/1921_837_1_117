package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile device);

    DeviceProfile findByDeviceId(String deviceId);

    List<DeviceProfile> findByUserId(long userId);

    DeviceProfile updateTrustStatus(long id, boolean trusted);
}
