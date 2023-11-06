package com.thelondruidsblog.app.thelonedruidsblogapp.controllers;

import com.thelondruidsblog.app.thelonedruidsblogapp.payloads.UserDto;
import com.thelondruidsblog.app.thelonedruidsblogapp.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = this.userService.createUser(userDto);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {
        UserDto updatedUser = this.userService.updateUser(userDto, userId);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer userId) {
        UserDto deletedUser = this.userService.deleteUser(userId);

        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = this.userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
        UserDto user = this.userService.getUserById(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
