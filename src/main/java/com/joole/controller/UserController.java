package com.joole.controller;

import com.joole.entity.User;
import com.joole.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.joole.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Optional<User> createdUserCredential = userService.createUser(user);

        if (createdUserCredential.isPresent()) {
            return new ResponseEntity<User>(createdUserCredential.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(user.getUsername() + " already exists. Please choose a unique username.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Incorrect username or password!", HttpStatus.NOT_FOUND);
        }

        final UserDetails userDetails = userService.loadUserByUsername(user.getUsername());

        final String jwt = jwtTokenUtil.genarateToken(userDetails);

        Map<String, String> map = new HashMap<>();
        map.put("jwt", jwt);
        map.put("expiresIn", jwtTokenUtil.extractExpiration(jwt).toString());
        map.put("id", Long.toString(userService.getUserByUsername(user.getUsername()).get().getUserId()));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<?> getUserById(@PathVariable long id) {
        Optional<User> user =  userService.getUserById(id);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>("User Not Found!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        Optional<User> user = userService.deleteUser(id);
        if (user.isPresent()) {
            return new ResponseEntity<>("Deleted " + user.get().getUsername() + " successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User Not Found!", HttpStatus.NOT_FOUND);
        }
    }
}


