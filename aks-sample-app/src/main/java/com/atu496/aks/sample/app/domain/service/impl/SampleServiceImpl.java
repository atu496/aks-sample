package com.atu496.aks.sample.app.domain.service.impl;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atu496.aks.sample.app.domain.dto.SampleRequest;
import com.atu496.aks.sample.app.domain.dto.SampleResponse;
import com.atu496.aks.sample.app.domain.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    RestTemplate resttemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${aks.sample.app.url1:http://aks-sample-service/aks-sample-service}")
    //    @Value("${aks.sample.app.url1}")
    private String SERVICE1_URL;

    @Value("${aks.sample.app.url2:http://aks-sample-service2/aks-sample-service2}")
    //    @Value("${aks.sample.app.url2}")
    private String SERVICE2_URL;

    @Value("${aks.sample.app.url3:http://aks-sample-service3/aks-sample-service3}")
    //    @Value("${aks.sample.app.url3}")
    private String SERVICE3_URL;

    public ResponseEntity<SampleResponse<String>> getAksSampleService() {
        return get(SERVICE1_URL);
    }

    @Override
    public ResponseEntity<SampleResponse<String>> getAksSampleService2() {
        return get(SERVICE2_URL);
    }

    @Override
    public ResponseEntity<SampleResponse<String>> getAksSampleService3() {
        return get(SERVICE3_URL);
    }

    @Override
    public ResponseEntity<SampleResponse<String>> postAksSampleService() {
        return post(SERVICE1_URL);
    }

    @Override
    public ResponseEntity<SampleResponse<String>> postAksSampleService2() {
        return post(SERVICE2_URL);
    }

    @Override
    public ResponseEntity<SampleResponse<String>> postAksSampleService3() {
        return post(SERVICE3_URL);
    }

    private ResponseEntity<SampleResponse<String>> get(String baseUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = null;
        try {
            uri = new URI(baseUrl + "/get");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        RequestEntity<Void> requestEntity = RequestEntity
                .get(uri)
                .build();

        ResponseEntity<SampleResponse<String>> res = resttemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<SampleResponse<String>>() {
                });
        return res;
    }

    private ResponseEntity<SampleResponse<String>> post(String baseUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = null;
        try {
            uri = new URI(baseUrl + "/post");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        RequestEntity<SampleRequest> requestEntity = RequestEntity.post(uri)
                .body(createQuery());
        ResponseEntity<SampleResponse<String>> res = resttemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<SampleResponse<String>>() {
                });
        return res;
    }

    private SampleRequest createQuery() {

        return new SampleRequest("1", "test");
    }
}
