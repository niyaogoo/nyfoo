package com.ny.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ny.service.entity.FooEntity;

public interface FooRepo extends JpaRepository<FooEntity, String> {

    List<FooEntity> findByName(String name);

    Long countByName(String name);

}
