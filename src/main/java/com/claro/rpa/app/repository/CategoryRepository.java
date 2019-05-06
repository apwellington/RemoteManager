package com.claro.rpa.app.repository;

import com.claro.rpa.app.model.RpaCategory;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<RpaCategory, Integer> {
}
