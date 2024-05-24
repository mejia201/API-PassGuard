package org.example.passwordmanager.User.Models;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetUserByIdModel {
    private Long userId;
    private LocalDateTime creation_date;
    private String email;
    private String password;
    private String username;
}
