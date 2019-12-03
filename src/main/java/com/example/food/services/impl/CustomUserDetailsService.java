package com.example.food.services.impl;

import com.example.food.models.Clients;
import com.example.food.repositories.ClientRepository;
import com.example.food.services.security.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kaminskiy.alexey
 * @since 2019.12
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public Clients getByLogin(String login) {
        return clientRepository.getByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Clients user = clientRepository.getByLogin(login);
        if (user != null) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getUserRole());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    private List<GrantedAuthority> getUserAuthority(UserRole role) {
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(role.name()));
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(Clients user, List<GrantedAuthority> authorities) {
        return new User(user.getLogin(), user.getPassword(), authorities);
    }

    public void saveUser(Clients user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.SIMPLE_USER_ROLE);
        clientRepository.save(user);
    }
}
