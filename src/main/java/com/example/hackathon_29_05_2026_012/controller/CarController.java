package com.example.hackathon_29_05_2026_012.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.hackathon_29_05_2026_012.model.dto.request.CarDto;
import com.example.hackathon_29_05_2026_012.model.dto.response.ApiDataRespon;
import com.example.hackathon_29_05_2026_012.model.entity.Car;
import com.example.hackathon_29_05_2026_012.service.impl.CarServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarServiceImpl service;

    @Value("${pageSize}")
    private Integer pageSize;

    // lấy + phân trang
    @GetMapping
    public ResponseEntity<ApiDataRespon<Page<Car>>> getCars(
            @RequestParam(name = "page", defaultValue = "0") Integer page) {
        return new ResponseEntity<>(new ApiDataRespon<>(true, "lay trang " + page + " thanh cong",
                service.getCars(page, pageSize), HttpStatus.OK), HttpStatus.OK);
    }

    // lấy theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiDataRespon<Car>> getCarById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new ApiDataRespon<>(true, "lay car id: " + id + " thanh cong",
                service.getCarById(id), HttpStatus.OK), HttpStatus.OK);
    }

    // thêm
    @PostMapping
    public ResponseEntity<ApiDataRespon<Boolean>> createCar(@Valid @RequestBody CarDto carDto) {
        return new ResponseEntity<>(new ApiDataRespon<>(true, "Them car thanh cong",
                service.createCar(carDto), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    // sửa
    @PatchMapping("/{id}")
    public ResponseEntity<ApiDataRespon<Boolean>> updateCar(@PathVariable("id") Long id,
            @Valid @RequestBody CarDto carDto) {
        return new ResponseEntity<>(new ApiDataRespon<>(true, "sua car thanh cong",
                service.updateCar(id, carDto), HttpStatus.OK), HttpStatus.OK);
    }

    // xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataRespon<Boolean>> deletecar(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new ApiDataRespon<>(true, "xoa car thanh cong",
                service.deleteCar(id), HttpStatus.NO_CONTENT), HttpStatus.NO_CONTENT);
    }

    // tìm theo tên và brand + phân trang
    @GetMapping("/search")
    public ResponseEntity<ApiDataRespon<Page<Car>>> searchCarContains(
            @RequestParam(name = "brand", defaultValue = "") String brand,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortType", defaultValue = "asc") String sortType

    ) {
        return new ResponseEntity<>(new ApiDataRespon<>(true, "tim kiem car thanh cong",
                service.searchCarByBrandContains(brand, page, pageSize, sortType), HttpStatus.OK),
                HttpStatus.OK);
    }

}
