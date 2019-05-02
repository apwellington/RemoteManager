package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaInputDetail;
import com.claro.rpa.app.repository.InputDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class InputDetailServiceImpl implements InputDetailService {

    @Autowired
    InputDetailRepository repository;

    @Override
    public Optional<RpaInputDetail> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<RpaInputDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public RpaInputDetail save(RpaInputDetail rpaIputDetail) {
        return repository.save(rpaIputDetail);
    }

    @Override
    public void delete(RpaInputDetail rpaIputDetail) {
        repository.delete(rpaIputDetail);
    }
}
