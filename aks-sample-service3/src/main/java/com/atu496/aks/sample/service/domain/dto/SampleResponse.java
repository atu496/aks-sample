package com.atu496.aks.sample.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SampleResponse<T> {

    private String version;

    private String resultCode;

    private String resultMessage;

    private T contents;

}
