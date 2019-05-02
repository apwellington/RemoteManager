package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaCategory;


import java.util.Optional;

public interface RpaCategoryService {
    public Optional<RpaCategory> findById(int id);
    public Iterable<RpaCategory> findAll();
    public RpaCategory save(RpaCategory user);
    public void delete(RpaCategory rpaUser);
}
