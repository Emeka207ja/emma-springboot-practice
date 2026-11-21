package com.emma.practice.service.impl;

import com.emma.practice.dtos.request.CreateUserDto;
import com.emma.practice.dtos.response.CreateUserResponse;
import com.emma.practice.dtos.response.UserDetails;
import com.emma.practice.model.User;
import com.emma.practice.repository.UserRepository;
import com.emma.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public CreateUserResponse createUser(CreateUserDto request) {

        User user = User.builder()
                .email(request.getEmail())
                .id(UUID.randomUUID())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .build();

        User savedUser = userRepository.save(user);

        return CreateUserResponse.builder()
                .id(savedUser.getId())
                .message("user saved successfully!")
                .build();
    }

    @Override
    public UserDetails getUser(String email) {
        User user = userRepository.getByEmail(email);
        return mapUserToUserDetails(user);
    }

    @Override
    public List<UserDetails> getUsers() {
        List<User> users = userRepository.getAllUsers();

        return users.stream().map(this::mapUserToUserDetails).collect(Collectors.toList());
    }

    private UserDetails mapUserToUserDetails(User user){
        return  UserDetails.builder()
                .id(user.getId())
                .email(user.getEmail())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .build();
    }
}
