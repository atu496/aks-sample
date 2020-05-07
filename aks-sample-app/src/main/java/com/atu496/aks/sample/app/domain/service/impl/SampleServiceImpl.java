package com.atu496.aks.sample.app.domain.service.impl;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${aks.sample.app.url1:http://localhost:8081/aks-sample-service}")
    //    @Value("${aks.sample.app.url1}")
    private String URL1;

    @Value("${aks.sample.app.url2:http://localhost:8082/aks-sample-service2}")
    //    @Value("${aks.sample.app.url2}")
    private String URL2;

    @Value("${aks.sample.app.url3:http://localhost:8083/aks-sample-service3}")
    //    @Value("${aks.sample.app.url3}")
    private String URL3;

    public ResponseEntity<SampleResponse<String>> getAksSampleService() {
        return get(URL1);
    }

    @Override
    public ResponseEntity<SampleResponse<String>> getAksSampleService2() {
        return get(URL2);
    }

    @Override
    public ResponseEntity<SampleResponse<String>> getAksSampleService3() {
        return get(URL3);
    }

    @Override
    public ResponseEntity<SampleResponse<String>> postAksSampleService() {
        return post(URL1);
    }

    @Override
    public ResponseEntity<SampleResponse<String>> postAksSampleService2() {
        return post(URL2);
    }

    @Override
    public ResponseEntity<SampleResponse<String>> postAksSampleService3() {
        return post(URL3);
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
