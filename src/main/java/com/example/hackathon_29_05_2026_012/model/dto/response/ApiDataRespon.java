package com.example.hackathon_29_05_2026_012.model.dto.response;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiDataRespon<T> {
    private Boolean status;
    private String mesage;
    private T data;
    private HttpStatus httpStatus;
}
