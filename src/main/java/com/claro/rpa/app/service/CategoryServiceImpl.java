package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaCategory;
import com.claro.rpa.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

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
