package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaInputDetail;
import com.claro.rpa.app.model.RpaUser;

import java.util.Optional;

public interface RpaIputDetailService {
    public Optional<RpaInputDetail> findById(int id);
    public Iterable<RpaInputDetail> findAll();
    public RpaInputDetail save(RpaInputDetail rpaIputDetail);
    public void delete(RpaInputDetail rpaIputDetail);
}
