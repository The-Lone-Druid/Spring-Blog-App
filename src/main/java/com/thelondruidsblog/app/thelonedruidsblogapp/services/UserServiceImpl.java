package com.thelondruidsblog.app.thelonedruidsblogapp.services;

import com.thelondruidsblog.app.thelonedruidsblogapp.entities.User;
import com.thelondruidsblog.app.thelonedruidsblogapp.exceptions.DataIntegrityViolationException;
import com.thelondruidsblog.app.thelonedruidsblogapp.exceptions.ResourceNotFoundException;
import com.thelondruidsblog.app.thelonedruidsblogapp.payloads.UserDto;
import com.thelondruidsblog.app.thelonedruidsblogapp.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        if(getUserByEmail(userDto.getEmail()) != null) {
            throw new DataIntegrityViolationException("User with email " + userDto.getEmail() + " already exists");
        }

        User user = this.modelMapper.map(userDto, User.class);
        User createdUser = this.userRepo.save(user);

        return this.modelMapper.map(createdUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepo.save(user);

        return this.modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User newUser = new User();
        newUser.setEmail(email);

        User user = this.userRepo.findOne(Example.of(newUser)).orElse(null);

        if(user != null) {
            return this.modelMapper.map(user, UserDto.class);
        }

        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();

        return users.stream().map(user -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        this.userRepo.delete(user);

        return this.modelMapper.map(user, UserDto.class);
    }
}
