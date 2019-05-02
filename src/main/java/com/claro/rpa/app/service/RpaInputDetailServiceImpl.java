package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaInputDetail;
import com.claro.rpa.app.repository.RpaInputDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RpaInputDetailServiceImpl implements RpaInputDetailService {

    @Autowired
    RpaInputDetailRepository repository;

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
