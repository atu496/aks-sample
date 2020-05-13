package com.atu496.aks.sample.app.pl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atu496.aks.sample.app.domain.dto.SampleResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HealthCheckController {

    @GetMapping("/healthcheck")
    public SampleResponse<String> get(ModelAndView mav) {
        return new SampleResponse<String>("1", "0", "Success", "HealthCheck OK!!");
    }
}
