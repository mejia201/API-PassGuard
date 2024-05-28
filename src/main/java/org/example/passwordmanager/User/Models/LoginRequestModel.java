package org.example.passwordmanager.User.Models;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginRequestModel {
    private String email;
    private String password;
}
