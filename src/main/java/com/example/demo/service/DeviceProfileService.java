package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile device);

    DeviceProfile getByDeviceId(String deviceId);
}
