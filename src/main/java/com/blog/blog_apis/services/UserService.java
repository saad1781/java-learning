package com.blog.blog_apis.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.blog_apis.entities.User;
import com.blog.blog_apis.payloads.UserDto;
import com.blog.blog_apis.repositories.UserRepo;
import com.blog.blog_apis.exceptions.*;;

public class UserService {
    @Autowired
    private UserRepo userRepository;

    UserService() {
    }

    UserDto createUser(UserDto user) {

        return this.EntityToDto(this.userRepository.save(this.DtoToEntity(user)));
    }

    UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", Long(userId)));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

        return this.EntityToDto(this.userRepository.save(user));
    }

    private Long Long(Integer userId) {
        return Long(userId);
    }

    UserDto getUserById(Integer userId) {
        return this.EntityToDto(this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", Long(userId))));
    }

    List<UserDto> getAllUsers() {
        List<UserDto> users = this.userRepository.findAll().stream().map(user->this.EntityToDto(user)).collect(Collectors.toList());
        return users;
    }

    void deleteUser(Integer userId) {
        this.userRepository.deleteById(userId);

    }

    private User DtoToEntity(UserDto user) {
        User userEntity = new User();
        userEntity.setName(user.getName());
        userEntity.setPassword(user.getPassword());
        userEntity.setAbout(user.getAbout());
        userEntity.setEmail(user.getEmail());

        return userEntity;
    }

    private UserDto EntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        userDto.setEmail(user.getEmail());

        return userDto;
    }
}
