package com.example.demo.Model.Repository;


import com.example.demo.Model.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The UserRepository interface extends JpaRepository to allow for CRUD operations
 * on User entities in the database.
 */
@Repository
public interface userRepository extends JpaRepository<user, Long> {
    /**
     * Method to find a User entity by its username field
     *
     * @param username The username of the User entity to search for
     * @return The found User entity or null if not found
     */
    user findByUsername(String username);
}


