package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;

import java.util.List;

public interface ViolationRecordService {
    ViolationRecord save(ViolationRecord record);
    ViolationRecord resolve(Long id);
    List<ViolationRecord> unresolved();
    List<ViolationRecord> all();
}
