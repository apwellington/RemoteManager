package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaRobot;
import com.claro.rpa.app.repository.RpaRobotRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RpaRobotServiceImpl implements RpaRobotService{

    @Autowired
    private RpaRobotRepository repository;


    @Override
    public Optional<RpaRobot> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<RpaRobot> findAll() {
        return repository.findAll();
    }

    @Override
    public RpaRobot save(RpaRobot robot) {
        return repository.save(robot);
    }

    @Override
    public void delete(RpaRobot robot) {
        repository.delete(robot);
    }
}
