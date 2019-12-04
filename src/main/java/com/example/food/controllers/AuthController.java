package com.example.food.controllers;

import com.example.food.config.JwtTokenProvider;
import com.example.food.dto.AuthBodyDTO;
import com.example.food.models.Clients;
import com.example.food.repositories.ClientRepository;
import com.example.food.services.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

/**
 * Auth controller to login users.
 *
 * @author kaminskiy.alexey
 * @since 2019.12
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private ClientRepository users;

    @Autowired
    private CustomUserDetailsService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthBodyDTO data) {
        try {
            String username = data.getLogin();
            Clients clients = userService.getByLogin(username);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username, this.users.getByLogin(username).getUserRole());
            Map<Object, Object> model = new HashMap<>();
            model.put("id", clients.getId());
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid login/password supplied");
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Clients user) {
        Clients userExists = userService.getByLogin(user.getLogin());
        if (userExists != null) {
            throw new BadCredentialsException("User with username: " + user.getLogin() + " already exists");
        }
        userService.saveUser(user);
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ok(model);
    }

    @RequestMapping("/user")
    public Long user(Principal user) {
        return userService.getByLogin(user.getName()).getId();
    }
}
