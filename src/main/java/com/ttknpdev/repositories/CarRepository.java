package com.ttknpdev.repositories;

import com.ttknpdev.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,String> { }
