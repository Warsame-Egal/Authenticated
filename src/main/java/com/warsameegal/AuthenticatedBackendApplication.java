package com.warsameegal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.warsameegal.models.ApplicationUser;
import com.warsameegal.models.Role;
import com.warsameegal.repository.RoleRepository;
import com.warsameegal.repository.UserRepository;

@SpringBootApplication
public class AuthenticatedBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthenticatedBackendApplication.class, args);
	}

	/**
	 * This CommandLineRunner bean will run when the application starts.
	 * It sets up initial roles and an admin user in the database.
	 *
	 * @param roleRepository  the repository for managing roles
	 * @param userRepository  the repository for managing users
	 * @param passwordEncoder the password encoder for hashing passwords
	 * @return a CommandLineRunner that sets up initial data
	 */
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository,
			PasswordEncoder passwordEncoder) {
		return args -> {
			// Check if the "ADMIN" role already exists in the database
			if (roleRepository.findByAuthority("ADMIN").isPresent()) {
				// If the "ADMIN" role exists, do nothing and return
				return;
			}

			// Create and save the "ADMIN" role in the database
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			// Create and save the "USER" role in the database
			roleRepository.save(new Role("USER"));

			// Create a set to hold the roles for the admin user
			Set<Role> roles = new HashSet<>();
			// Add the "ADMIN" role to the set
			roles.add(adminRole);

			// Create a new admin user with the username "admin" and password "password"
			// The password is hashed using the password encoder
			ApplicationUser admin = new ApplicationUser(null, "admin", passwordEncoder.encode("password"), roles);

			// Save the admin user in the database
			userRepository.save(admin);
		};
	}
}