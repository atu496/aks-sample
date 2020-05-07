package com.atu496.aks.sample.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SampleResponse<T> {

    private String version;

    private String resultCode;

    private String resultMessage;

    private T contents;

}
