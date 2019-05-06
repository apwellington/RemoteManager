package com.claro.rpa.app.restcontroller;

import com.claro.rpa.app.model.RpaUser;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CrudRestService {
    public List<?> allUsers();
    public ResponseEntity<?> user(int id);
    public ResponseEntity<?> save(Object object);
    public ResponseEntity delete(int id);
}
