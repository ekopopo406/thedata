package com.lab.common;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T data;
    private int code;
    private String message;
 
    public ApiResponse(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }
 
    // getters and setters
}