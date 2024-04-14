package com.ttknpdev.controller;

import com.ttknpdev.constant.CommonStatus;
import com.ttknpdev.entities.Car;
import com.ttknpdev.entity.ResponseObject;
import com.ttknpdev.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class RouterCarControl {
    private CarService carService;
    @Autowired
    public RouterCarControl(CarService carService) {
        this.carService = carService;
    }
    @GetMapping(value = "/reads")
    private ResponseEntity<ResponseObject> reads() {
        return ResponseEntity.ofNullable(
                ResponseObject
                        .<List<Car>>builder()
                        .status((short)CommonStatus.ACCEPTED[0])
                        .info((String) CommonStatus.ACCEPTED[1])
                        .data(carService.retrieveAllCars())
                        .build()
        );
    }


    @GetMapping(value = "/read")
    private ResponseEntity<ResponseObject> read(@RequestParam String cid) {
        return ResponseEntity.ofNullable(
                ResponseObject
                        .<Car>builder()
                        .status((short)CommonStatus.ACCEPTED[0])
                        .info((String) CommonStatus.ACCEPTED[1])
                        .data(carService.retrieveCar(cid))
                        .build()
        );
    }

    @PostMapping(value = "/create")
    private ResponseEntity<ResponseObject> create(@RequestBody Car car) {
        return ResponseEntity.ofNullable(
                ResponseObject
                        .<Boolean>builder()
                        .status((short)CommonStatus.CREATE[0])
                        .info((String) CommonStatus.CREATE[1])
                        .data(carService.addCar(car))
                        .build()
        );
    }

    @DeleteMapping(value = "/delete")
    private ResponseEntity<ResponseObject> delete(@RequestParam String cid) {
        return ResponseEntity.ofNullable(
                ResponseObject
                        .<Boolean>builder()
                        .status((short)CommonStatus.ACCEPTED[0])
                        .info((String) CommonStatus.ACCEPTED[1])
                        .data(carService.removeCar(cid))
                        .build()
        );
    }

    @PutMapping(value = "/update")
    private ResponseEntity<ResponseObject> update(@RequestParam String cid,@RequestBody Car car) {
        return ResponseEntity.ofNullable(
                ResponseObject
                        .<Boolean>builder()
                        .status((short)CommonStatus.ACCEPTED[0])
                        .info((String) CommonStatus.ACCEPTED[1])
                        .data(carService.editCar(cid,car))
                        .build()
        );
    }

}
