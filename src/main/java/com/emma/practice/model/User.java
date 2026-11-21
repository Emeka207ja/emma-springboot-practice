package com.emma.practice.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class User {
    private UUID id;
    private String email;
    private String firstname;
    private String lastname;
}
