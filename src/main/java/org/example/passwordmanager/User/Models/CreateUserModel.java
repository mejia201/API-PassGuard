package org.example.passwordmanager.User.Models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateUserModel {
    private String email;
    private String password;
    private String username;
}
