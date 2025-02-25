package com.warsameegal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warsameegal.models.ApplicationUser;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Integer> {
    /**
     * Finds an ApplicationUser by their username.
     *
     * @param username the username of the user to be found
     * @return an Optional containing the found ApplicationUser, or an empty
     *         Optional if no user is found
     */
    Optional<ApplicationUser> findByUsername(String username);
}