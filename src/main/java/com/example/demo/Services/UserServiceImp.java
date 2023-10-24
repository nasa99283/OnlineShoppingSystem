package com.example.demo.Services;

import com.example.demo.Admin.UserDto;
import com.example.demo.Model.Entity.User;
import com.example.demo.Model.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),userDto.getRole(),userDto.getFullname());
        return userRepository.save(user);
    }


}
