package com.example.demo.Controller;


import com.example.demo.Model.Entity.user;


import java.util.List;

/**
 * Interface for UserController. Contains methods for handling user related operations
 */
public interface UserControllerInterface {
    /**
     * Retrieves a list of all users
     *
     * @return list of all users
     */
    List<user> getUsers();

    /**
     * Saves a new user
     *
     * @param user the user to be saved
     * @return the saved user
     */
  user saveUser(user user);
}
