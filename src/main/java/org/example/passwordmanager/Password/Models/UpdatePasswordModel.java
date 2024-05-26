package org.example.passwordmanager.Password.Models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordModel {

    private Long passwordId;
    private Long userId;
    private Long platformId;
    private Long categoryId;
    private String platformUsername;
    private String password;


}
