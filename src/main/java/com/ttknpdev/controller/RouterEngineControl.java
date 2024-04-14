package com.ttknpdev.controller;

import com.ttknpdev.constant.CommonStatus;
import com.ttknpdev.entities.Car;
import com.ttknpdev.entities.Engine;
import com.ttknpdev.entity.ResponseObject;
import com.ttknpdev.services.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/engine")
public class RouterEngineControl {
    private EngineService engineService;
    @Autowired
    public RouterEngineControl(EngineService engineService) {
        this.engineService = engineService;
    }
    @GetMapping(value = "/reads")
    private ResponseEntity<ResponseObject> reads() {
        return ResponseEntity.ofNullable(
                ResponseObject
                        .<List<Engine>>builder()
                        .status((short) CommonStatus.ACCEPTED[0])
                        .info((String) CommonStatus.ACCEPTED[1])
                        .data(engineService.retrieveAllEngines())
                        .build()
        );
    }
}
