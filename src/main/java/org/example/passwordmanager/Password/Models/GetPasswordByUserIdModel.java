package org.example.passwordmanager.Password.Models;

import lombok.*;
import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Platform.Models.Platform;
import org.example.passwordmanager.User.Models.User;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPasswordByUserIdModel {
    private Long passwordId;

    private Long userId;

    private Long platform_id;

    private Long categoryId;

    private String platformUsername;
    private String password;
    private LocalDateTime creationDate;
}
