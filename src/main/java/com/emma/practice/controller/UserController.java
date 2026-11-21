package com.emma.practice.controller;

import com.emma.practice.dtos.request.CreateUserDto;
import com.emma.practice.dtos.response.CreateUserResponse;
import com.emma.practice.dtos.response.UserDetails;
import com.emma.practice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserDto request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(request));
    }

    @GetMapping("/{email}")
    ResponseEntity<UserDetails> getUser(@PathVariable String email){
        return ResponseEntity.ok().body(
                userService.getUser(email)
        );
    }

    @GetMapping("/all-users")
    ResponseEntity<List<UserDetails>> getAllUsers(){
        return ResponseEntity.ok().body(
                userService.getUsers()
        );
    }
}
