package com.warsameegal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.warsameegal.models.ApplicationUser;
import com.warsameegal.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder; // Password encoder to hash passwords

    @Autowired
    private UserRepository userRepository;

    /**
     * Loads the user details by username.
     * This method is used by Spring Security to authenticate and authorize users.
     *
     * @param username the username of the user to be loaded
     * @return the UserDetails object containing user information
     * @throws UsernameNotFoundException if the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Log the method call for debugging purposes
        System.out.println("Attempting to load user by username: " + username);

        // Find the user by username in the database
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}