package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaRobot;

import java.util.Optional;

public interface RobotService {
    public Optional<RpaRobot> findById(int id);
    public Iterable<RpaRobot> findAll();
    public RpaRobot save(RpaRobot robot);
    public void delete(RpaRobot robot);
}
