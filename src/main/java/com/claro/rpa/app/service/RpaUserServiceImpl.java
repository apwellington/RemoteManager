package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaUser;
import com.claro.rpa.app.repository.RpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RpaUserService {

    @Autowired
    private RpaUserRepository rpaUserRepository;

    public Optional<RpaUser> findById(int id){
        return rpaUserRepository.findById(id);
    }

    public Iterable<RpaUser> findAll(){
        return rpaUserRepository.findAll();
    }
}
