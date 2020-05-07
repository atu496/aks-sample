package com.atu496.aks.sample.app.domain.service;

import org.springframework.http.ResponseEntity;

import com.atu496.aks.sample.app.domain.dto.SampleResponse;

public interface SampleService {

    public ResponseEntity<SampleResponse<String>> getAksSampleService();

    public ResponseEntity<SampleResponse<String>> getAksSampleService2();

    public ResponseEntity<SampleResponse<String>> getAksSampleService3();

    public ResponseEntity<SampleResponse<String>> postAksSampleService();

    public ResponseEntity<SampleResponse<String>> postAksSampleService2();

    public ResponseEntity<SampleResponse<String>> postAksSampleService3();

}
