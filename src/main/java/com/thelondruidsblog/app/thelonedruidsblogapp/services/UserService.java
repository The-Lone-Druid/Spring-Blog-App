package com.thelondruidsblog.app.thelonedruidsblogapp.services;

import com.thelondruidsblog.app.thelonedruidsblogapp.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    UserDto deleteUser(Integer userId);
}
