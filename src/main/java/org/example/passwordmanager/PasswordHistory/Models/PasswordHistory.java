package org.example.passwordmanager.PasswordHistory.Models;

import jakarta.persistence.*;
import lombok.*;
import org.example.passwordmanager.Platform.Models.Platform;
import org.example.passwordmanager.User.Models.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "PasswordHistory")
public class PasswordHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

    private String previousEncryptedPassword;
    private String changeDate;

}
