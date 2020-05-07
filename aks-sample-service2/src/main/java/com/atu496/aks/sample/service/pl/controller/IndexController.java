package com.atu496.aks.sample.service.pl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atu496.aks.sample.service.domain.dto.SampleRequest;
import com.atu496.aks.sample.service.domain.dto.SampleResponse;
import com.atu496.aks.sample.service.domain.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class IndexController {

    @Autowired
    SampleService service;

    @GetMapping("/get")
    public SampleResponse<String> get(HttpServletRequest req, HttpServletResponse res, SampleRequest sampleRequest) {
        log.info(service.get());

        return new SampleResponse<String>("1", "0", "Success GetRequest", "this service is aks-sample-service");
    }

    @PostMapping("/post")
    public SampleResponse<String> post(HttpServletRequest req, HttpServletResponse res, SampleRequest sampleRequest) {
        log.info(service.get());

        return new SampleResponse<String>("1", "0", "success PostRequest", "this service is aks-sample-service");
}
}