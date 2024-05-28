package org.example.passwordmanager.Platform.Models;

import jakarta.persistence.*;
import lombok.*;
import org.example.passwordmanager.User.Models.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Platforms")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long platform_id;
    private String description;
    private String platform_name;
    private String url;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

}
