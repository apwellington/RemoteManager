package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaInputType;
import com.claro.rpa.app.repository.InputTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class InputTypeServiceImpl implements InputTypeService {
    @Autowired
    private InputTypeRepository repository;

    @Override
    public Optional<RpaInputType> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<RpaInputType> findAll() {
        return repository.findAll();
    }

    @Override
    public RpaInputType save(RpaInputType rpaInputType) {
        return repository.save(rpaInputType);
    }

    @Override
    public void delete(RpaInputType rpaInputType) {
        repository.delete(rpaInputType);
    }
}
