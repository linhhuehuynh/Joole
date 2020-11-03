package com.joole.service;

import com.joole.entity.User;
import com.joole.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    public Optional<User> createUser(User user) {
        User existUser = userRepo.findByUsername(user.getUsername());
        if(existUser != null) {
            return Optional.empty();
        } else {
            userRepo.save(user);
            User createdUser = userRepo.findByUsername(user.getUsername());
            createdUser.setPassword("");
            return Optional.of(createdUser);
        }
    }

    public Optional<User> getUserById(long id) {
        return userRepo.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return Optional.of(userRepo.findByUsername(username));
    }

    public Optional<User> deleteUser(long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            userRepo.deleteById(id);
            return Optional.of(user.get());
        }
        return Optional.empty();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Username doesn't exist!");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }
}
