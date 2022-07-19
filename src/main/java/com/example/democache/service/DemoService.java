package com.example.democache.service;

import com.example.democache.entity.DemoEntity;
import com.example.democache.repository.DemoRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class DemoService {

    private DemoRepository demoRepository;

    @CacheEvict(cacheNames = {"demos"}, allEntries = true)
    public DemoEntity save(DemoEntity demo) {
        return demoRepository.save(demo);
    }


    @Cacheable(value = "demos" )
    public List<DemoEntity> getDemos() {
        return demoRepository.findAll();
    }

    @Cacheable(value = "demo" , key = "#id")
    public DemoEntity getDemo(Long id) {
        return demoRepository.findById(id).orElse(new DemoEntity());
    }
}
