package com.claro.rpa.app.repository;

import com.claro.rpa.app.model.RpaRobot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RobotRepository extends CrudRepository<RpaRobot, Integer> {
}
