package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/violations")
public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ViolationRecord> create(@RequestBody ViolationRecord record) {
        return ResponseEntity.ok(service.create(record));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> getByUser(@PathVariable long userId) {
        return ResponseEntity.ok(service.getByUser(userId));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ViolationRecord> resolve(@PathVariable long id) {
        return ResponseEntity.ok(service.resolve(id));
    }
}
