package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordRepository repo;

    public ViolationRecordController(ViolationRecordRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ViolationRecord log(@RequestBody ViolationRecord record) {
        return repo.save(record);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> byUser(@PathVariable Long userId) {
        return repo.findAll()
                   .stream()
                   .filter(v -> v.getUserId().equals(userId))
                   .toList();
    }

    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id) {
        ViolationRecord v = repo.findById(id).orElseThrow();
        v.setResolved(true);
        return repo.save(v);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved() {
        return repo.findByResolvedFalse();
    }

    @GetMapping
    public List<ViolationRecord> all() {
        return repo.findAll();
    }
}
