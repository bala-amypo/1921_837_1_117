package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
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
    public ViolationRecord create(@RequestBody ViolationRecord record) {
        return service.createViolation(record);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> getUnresolved() {
        return service.getUnresolvedViolations();
    }

    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable long id) {
        return service.resolveViolation(id);
    }
}
