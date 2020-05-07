package com.atu496.aks.sample.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SampleRequest {

    private String version;

    private String param;

}
