package com.atu496.aks.sample.service.domain.service.impl;

import org.springframework.stereotype.Service;

import com.atu496.aks.sample.service.domain.service.SampleService;
@Service
public class SampleServiceImpl implements SampleService {

    @Override
    public String get() {
        return "test";
    }

}
