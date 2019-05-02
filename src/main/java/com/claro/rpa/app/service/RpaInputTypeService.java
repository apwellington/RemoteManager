package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaInputType;

import java.util.Optional;

public interface RpaInputType {
    public Optional<RpaInputType> findById(int id);
    public Iterable<RpaInputType> findAll();
    public RpaInputType save(RpaInputType user);
    public void delete(RpaInputType rpaUser);
}
