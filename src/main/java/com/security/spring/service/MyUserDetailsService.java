package com.security.spring.service;

import com.security.spring.modelDTO.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace this with your own user retrieval logic (e.g., from a database)
        if (!username.equals("admin")) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new MyUserDetails("admin", "admin@123", Collections.emptyList());
    }
}
