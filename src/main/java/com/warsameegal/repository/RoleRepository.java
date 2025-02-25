package com.warsameegal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warsameegal.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    /**
     * Find a role by its authority.
     * This method will be used to check if a role with a specific authority (e.g.,
     * "ADMIN") exists in the database.
     *
     * @param authority the authority of the role to find
     * @return an Optional containing the role if found, or an empty Optional if not
     *         found
     */
    Optional<Role> findByAuthority(String authority);

}