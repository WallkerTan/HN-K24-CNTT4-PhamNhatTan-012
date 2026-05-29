package com.example.hackathon_29_05_2026_012.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);// truyền tb lỗi lên runtimeexxception
    }

}
