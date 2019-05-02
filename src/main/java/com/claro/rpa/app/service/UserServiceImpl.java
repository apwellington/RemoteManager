package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaUser;
import com.claro.rpa.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<RpaUser> findById(int id){
        return userRepository.findById(id);
    }

    @Override
    public Iterable<RpaUser> findAll(){
        return userRepository.findAll();
    }

    @Override
    public RpaUser save(RpaUser user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(RpaUser rpaUser) {
        userRepository.delete(rpaUser);
    }
}
