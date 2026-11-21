package com.emma.practice.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class CreateUserResponse {
    private UUID id;
    private String message;
}
