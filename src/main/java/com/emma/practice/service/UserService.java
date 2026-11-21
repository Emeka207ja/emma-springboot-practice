package com.emma.practice.service;

import com.emma.practice.dtos.request.CreateUserDto;
import com.emma.practice.dtos.response.CreateUserResponse;
import com.emma.practice.dtos.response.UserDetails;

import java.util.List;

public interface UserService {
    CreateUserResponse createUser(CreateUserDto request);

    UserDetails getUser(String email);

    List<UserDetails> getUsers();
}
