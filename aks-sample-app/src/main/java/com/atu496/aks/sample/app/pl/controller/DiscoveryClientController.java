package com.atu496.aks.sample.app.pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atu496.aks.sample.app.domain.dto.SampleResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DiscoveryClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/list/service")
    public SampleResponse get(ModelAndView mav) {

        return new SampleResponse("1","0","succese",discoveryClient.getServices());
    }


}
