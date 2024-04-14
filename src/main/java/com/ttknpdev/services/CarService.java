package com.ttknpdev.services;

import com.ttknpdev.entities.Car;
import com.ttknpdev.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;
    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public List<Car> retrieveAllCars(){
        return carRepository.findAll();
    }

    public Car retrieveCar(String cid){
        return carRepository.findById(cid).orElse(null);
    }
    public Boolean addCar(Car car) {
        return carRepository.save(car).getCid() != null;
    }
    public Boolean removeCar(String cid) {
        return carRepository.findById(cid).map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
        /*
        *** Very smart it remove relation table too!!!
        Hibernate: delete from cars_engines where cid=?
        Hibernate: delete from cars where cid=?
        Hibernate: delete from engines where eid=?
        */
    }

    public Boolean editCar(String cid,Car newCar) {
        return carRepository.findById(cid).map(car -> {
            car.setBrand(newCar.getBrand());
            car.setModel(newCar.getModel());
            car.setReleaseDate(newCar.getReleaseDate());
            car.setPrice(newCar.getPrice());
            car.setEngine(newCar.getEngine());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }
}
