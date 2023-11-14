package com.blog.blog_apis.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog_apis.entities.User;
import com.blog.blog_apis.payloads.UserDto;
import com.blog.blog_apis.repositories.UserRepo;
import com.blog.blog_apis.exceptions.*;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ModelMapper modelMapper;

    UserService() {
    }

    public UserDto createUser(UserDto user) {

        return this.EntityToDto(this.userRepository.save(this.DtoToEntity(user)));
    }

    public UserDto updateUser(UserDto userDto, Integer userId) {
        long id = Long.valueOf(userId);
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

        return this.EntityToDto(this.userRepository.save(user));
    }

    public UserDto getUserById(Integer userId) {
        long id = Long.valueOf(userId);
        return this.EntityToDto(this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id)));
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> users = this.userRepository.findAll().stream().map(user -> this.EntityToDto(user))
                .collect(Collectors.toList());
        return users;
    }

    public void deleteUser(Integer userId) {
        this.userRepository.deleteById(userId);

    }

    private User DtoToEntity(UserDto user) {
        User userEntity = this.modelMapper.map(user, User.class);

        // userEntity.setName(user.getName());
        // userEntity.setPassword(user.getPassword());
        // userEntity.setAbout(user.getAbout());
        // userEntity.setEmail(user.getEmail());

        return userEntity;
    }

    private UserDto EntityToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        // userDto.setId(user.getId());
        // userDto.setName(user.getName());
        // userDto.setPassword(user.getPassword());
        // userDto.setAbout(user.getAbout());
        // userDto.setEmail(user.getEmail());

        return userDto;
    }
}
