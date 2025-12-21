package com.example.demo.repository;

import com.example.demo.entity.ServiceCounter;

import java.util.List;
import java.util.Optional;

public interface ServiceCounterRepository {

    ServiceCounter save(ServiceCounter counter);

    Optional<ServiceCounter> findById(Long id);

    List<ServiceCounter> findByIsActiveTrue();
}
