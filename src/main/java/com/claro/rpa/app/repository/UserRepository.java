package com.claro.rpa.app.repository;

import com.claro.rpa.app.model.RpaUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<RpaUser, Integer> {
    public Optional<RpaUser> findByUsername(String username);

}
