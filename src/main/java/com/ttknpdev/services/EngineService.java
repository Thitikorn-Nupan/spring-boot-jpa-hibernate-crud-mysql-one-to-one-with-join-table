package com.ttknpdev.services;

import com.ttknpdev.entities.Engine;
import com.ttknpdev.repositories.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineService {
    private EngineRepository engineRepository;

    @Autowired
    public EngineService(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }
    public List<Engine> retrieveAllEngines() {
        return engineRepository.findAll();
    }
}
