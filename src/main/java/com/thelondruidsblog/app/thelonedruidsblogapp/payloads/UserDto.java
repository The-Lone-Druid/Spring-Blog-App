package com.thelondruidsblog.app.thelonedruidsblogapp.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 4,  max = 255, message = "Please enter a valid name")
    private String name;

    @Email(message = "Please enter a valid email")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotEmpty(message = "About cannot be empty")
    private String about;

}
