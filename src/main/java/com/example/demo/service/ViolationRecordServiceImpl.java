package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repo;

    public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ViolationRecord save(ViolationRecord record) {
        return repo.save(record);
    }

    @Override
    public ViolationRecord resolve(Long id) {
        ViolationRecord v = repo.findById(id).orElseThrow();
        v.setResolved(true);
        return repo.save(v);
    }

    @Override
    public List<ViolationRecord> unresolved() {
        return repo.findByResolvedFalse();
    }

    @Override
    public List<ViolationRecord> all() {
        return repo.findAll();
    }
}
