package com.example.hackathon_29_05_2026_012.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.example.hackathon_29_05_2026_012.model.dto.request.CarDto;
import com.example.hackathon_29_05_2026_012.model.entity.Car;
import com.example.hackathon_29_05_2026_012.repository.CarRepo;
import com.example.hackathon_29_05_2026_012.service.CarService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepo repo;

    @Override
    public Page<Car> getCars(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return repo.findAll(pageable);
    }

    @Override
    public Car getCarById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Boolean createCar(CarDto carDto) {
        Car c = toEntity(carDto);
        return repo.save(c) != null;
    }

    @Override
    public Boolean updateCar(Long id, CarDto carDto) {
        Car c = getCarById(id);
        if (c == null)
            return false;
        c.setBrand(carDto.getBrand());
        c.setModel(carDto.getModel());
        c.setPrice(carDto.getPrice());
        c.setStatus(carDto.getStatus());
        c.setIs_delete(carDto.getIs_delete());
        return repo.save(c) != null;
    }

    @Override
    public Boolean deleteCar(Long id) {
        Car c = getCarById(id);
        if (c == null)
            return false;
        repo.delete(c);
        return true;
    }

    @Override
    public Page<Car> searchCarByNameAndBrandContains(String name, String brand, Integer page,
            Integer pageSize, String sortType) {

        Sort sort = null;
        Sort.Direction direction =
                sortType.equalsIgnoreCase("asc") ? Direction.ASC : Direction.DESC;
        if (name == null && brand == null) {
            sort = Sort.by(direction, "brand");
        } else if (brand == null) {
            sort = Sort.by(direction, "name");
        } else {
            sort = Sort.by(direction, "brand");
        }
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        return repo.searchCarByNameAndBrandContains(name, brand, pageable);
    }

    private Car toEntity(CarDto carDto) {
        return Car.builder().model(carDto.getModel()).brand(carDto.getBrand())
                .price(carDto.getPrice()).status(carDto.getStatus())
                .is_delete(carDto.getIs_delete()).build();
    }

}
