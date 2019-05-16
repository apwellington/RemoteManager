package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaRobot;
import com.claro.rpa.app.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RobotServiceImpl implements RobotService {

    @Autowired
    private RobotRepository repository;


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

    @Override
    public Optional<RpaRobot> findByName(String name) {
        return null; //pendiente
    }

    @Override
    public List<RpaRobot> rpaRobotsByUserId(int id) {
        return null;
    }
}
