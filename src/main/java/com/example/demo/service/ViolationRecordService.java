package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;

import java.util.List;

public interface ViolationRecordService {

    ViolationRecord createViolation(ViolationRecord record);

    List<ViolationRecord> getUnresolvedViolations();

    ViolationRecord resolveViolation(long id);
}
