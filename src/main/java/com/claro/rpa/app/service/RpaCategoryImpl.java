package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaCategory;
import com.claro.rpa.app.repository.RpaCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RpaCategoryImpl implements RpaCategoryService {

    @Autowired
    private RpaCategoryRepository repository;

    @Override
    public Optional<RpaCategory> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<RpaCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public RpaCategory save(RpaCategory category) {
        return repository.save(category);
    }

    @Override
    public void delete(RpaCategory rc) {
        repository.delete(rc);
    }
}
