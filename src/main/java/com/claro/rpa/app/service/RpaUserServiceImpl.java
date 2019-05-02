package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaUser;
import com.claro.rpa.app.repository.RpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RpaUserServiceImpl implements RpaUserService{

    @Autowired
    private RpaUserRepository rpaUserRepository;

    @Override
    public Optional<RpaUser> findById(int id){

        return rpaUserRepository.findById(id);
    }

    @Override
    public Iterable<RpaUser> findAll(){
        return rpaUserRepository.findAll();
    }

    @Override
    public RpaUser save(RpaUser user) {
        return rpaUserRepository.save(user);
    }

    @Override
    public void delete(RpaUser rpaUser) {
        rpaUserRepository.delete(rpaUser);
    }
}
