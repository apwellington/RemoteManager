package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaRobot;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RobotService {
    public Optional<RpaRobot> findById(int id);
    public Iterable<RpaRobot> findAll();
    public RpaRobot save(RpaRobot robot);
    public void delete(RpaRobot robot);
    public Optional<RpaRobot> findByName(String name);

    @Query(
            value = "SELECT * FROM Rpa r WHERE r. = ?1",
            nativeQuery = true)
    public List<RpaRobot> rpaRobotsByUserId(int id);
}
