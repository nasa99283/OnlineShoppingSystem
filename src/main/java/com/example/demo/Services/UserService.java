package com.example.demo.Services;

import com.example.demo.Admin.UserDto;
import com.example.demo.Model.Entity.User;

public interface UserService {

    User save (UserDto userDto);
}
