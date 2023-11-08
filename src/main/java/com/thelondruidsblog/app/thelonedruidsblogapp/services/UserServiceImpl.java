package com.thelondruidsblog.app.thelonedruidsblogapp.services;

import com.thelondruidsblog.app.thelonedruidsblogapp.entities.User;
import com.thelondruidsblog.app.thelonedruidsblogapp.exceptions.ResourceNotFoundException;
import com.thelondruidsblog.app.thelonedruidsblogapp.payloads.UserDto;
import com.thelondruidsblog.app.thelonedruidsblogapp.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToEntity(userDto);
        User createdUser = this.userRepo.save(user);

        return this.entityToDto(createdUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepo.save(user);

        return this.entityToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return this.entityToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();

        List<UserDto> userDtos = users.stream().map(this::entityToDto).toList();

        return userDtos;
    }

    @Override
    public UserDto deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        this.userRepo.delete(user);

        return this.entityToDto(user);
    }

    private User dtoToEntity(UserDto userDto) {
        return this.modelMapper.map(userDto, User.class);
    }

    private UserDto entityToDto(User user) {
        return this.modelMapper.map(user, UserDto.class);
    }
}
