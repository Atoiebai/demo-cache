package com.example.democache.controller;


import com.example.democache.entity.DemoEntity;
import com.example.democache.repository.DemoRepository;
import com.example.democache.service.DemoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DemoController {

    private final DemoService demoService;


   @GetMapping("api/v1/demo")
    public ResponseEntity<List<DemoEntity>> findAll() {
        return ResponseEntity.ok(demoService.getDemos());
    }


    @PostMapping("/api/v1/demo")
    public ResponseEntity<DemoEntity> createDemo(@RequestBody DemoEntity entity) {
      return ResponseEntity.ok(demoService.save(entity));
    }

    @GetMapping("api/v1/demo/{id}")
    public ResponseEntity<DemoEntity> findById(@PathVariable Long id) {
       return ResponseEntity.ok(demoService.getDemo(id));
    }
}
