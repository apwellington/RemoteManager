package com.claro.rpa.app.repository;

import com.claro.rpa.app.model.RpaUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RpaUserRepository extends CrudRepository<RpaUser, Integer> {

}
