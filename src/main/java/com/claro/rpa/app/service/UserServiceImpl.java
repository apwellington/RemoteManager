package com.claro.rpa.app.service;

import com.claro.rpa.app.model.RpaUser;
import com.claro.rpa.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class UserServiceImpl  implements UserDetailsService, UserService {

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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        RpaUser user = userRepository.findByUsername(s);

        System.out.println(user.toString());

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(String.valueOf(user.getId()), user.getPassword(),getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}
