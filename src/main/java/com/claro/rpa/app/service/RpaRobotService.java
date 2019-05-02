package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaUser;

import java.util.Optional;

public interface RpaRobot {

    public Optional<RpaRobot> findById(int id);
    public Iterable<RpaRobot> findAll();
    public RpaUser save(RpaRobot robot);
    public void delete(RpaRobot robot);
}
