package com.example.democache.repository;


import com.example.democache.entity.DemoEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Long> {

//    @Cacheable(cacheNames = {"findAllCache"})
    List<DemoEntity> findAll();

//    @CacheEvict(value ="findAllCache" , allEntries = true, beforeInvocation = true)
    DemoEntity save(DemoEntity entity);
}
