package com.example.hackathon_29_05_2026_012.exception.handler;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.hackathon_29_05_2026_012.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlerProductNotFoundException(
            ProductNotFoundException e) {

        log.warn("khong tim thay du lieu", e.getMessage());


        Map<String, String> res = new HashMap<>();
        res.put("error", "Not_found");
        res.put("message", e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlerGlobleException(Exception e) {

        log.error("loi he thong", e);

        return new ResponseEntity<>("system error: " + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // bắt lỗi validator
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException e) {
        log.warn("validator false");
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
