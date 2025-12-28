package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repo;

    public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ViolationRecord create(ViolationRecord record) {
        record.setResolved(false);
        return repo.save(record);
    }

    @Override
    public List<ViolationRecord> getByUser(long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public ViolationRecord resolve(long id) {
        ViolationRecord record = repo.findById(id).orElseThrow();
        record.setResolved(true);
        return repo.save(record);
    }
}
