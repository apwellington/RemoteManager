package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaUser;

import java.util.Optional;


public interface UserService {

    public Optional<RpaUser> findById(int id);
    public Iterable<RpaUser> findAll();
    public RpaUser save(RpaUser user);
    public void delete(RpaUser rpaUser);
    public RpaUser findById();
}
