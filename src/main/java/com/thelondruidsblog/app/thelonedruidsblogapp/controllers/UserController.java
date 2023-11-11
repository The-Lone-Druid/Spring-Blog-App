package com.thelondruidsblog.app.thelonedruidsblogapp.controllers;

import com.thelondruidsblog.app.thelonedruidsblogapp.payloads.UserDto;
import com.thelondruidsblog.app.thelonedruidsblogapp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUser = this.userService.createUser(userDto);

        return new ResponseEntity<UserDto>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {
        UserDto updatedUser = this.userService.updateUser(userDto, userId);

        return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<UserDto> deleteUser(@Valid @PathVariable Integer userId) {
        UserDto deletedUser = this.userService.deleteUser(userId);

        return new ResponseEntity<UserDto>(deletedUser, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = this.userService.getAllUsers();

        return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getUserById(@Valid @PathVariable Integer userId) {
        UserDto user = this.userService.getUserById(userId);

        return new ResponseEntity<UserDto>(user, HttpStatus.OK);
    }
}
