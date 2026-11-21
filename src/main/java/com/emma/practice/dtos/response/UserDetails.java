package com.emma.practice.dtos.response;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class UserDetails {
    private UUID id;
    private String email;
    private String firstname;
    private String lastname;
}
