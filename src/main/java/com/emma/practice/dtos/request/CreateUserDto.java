package com.emma.practice.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    @NotNull(message = "email is required!")
    @NotEmpty(message = "email must not be empty")
    @Email(message = "please supply a valid email")
    private String email;
    private String firstname;
    private String lastname;

}
