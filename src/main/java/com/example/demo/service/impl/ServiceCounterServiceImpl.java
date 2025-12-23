package com.example.demo.service.impl;

import com.example.demo.entity.ServiceCounter;
import com.example.demo.repository.ServiceCounterRepository;
import com.example.demo.service.ServiceCounterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCounterServiceImpl implements ServiceCounterService {

    private final ServiceCounterRepository serviceCounterRepository;

    public ServiceCounterServiceImpl(ServiceCounterRepository serviceCounterRepository) {
        this.serviceCounterRepository = serviceCounterRepository;
    }

    @Override
    public List<ServiceCounter> findAll() {
        return serviceCounterRepository.findAll();
    }
}
