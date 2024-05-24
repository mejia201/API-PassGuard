package org.example.passwordmanager.User.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UpdateUserModel {
    private Long userId;
    private LocalDateTime creation_date;
    private String email;
    private String password;
    private String username;
}
