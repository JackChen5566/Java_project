package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> searchCars(String keyword) {
        return carRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    
    public Car getCarById(Long id) {
    	Optional<Car> car = carRepository.findById(id);
    	return car.orElseThrow(() -> new RuntimeException("Id not found :"  + id) );
    	
    }
    
}
