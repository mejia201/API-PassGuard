package org.example.passwordmanager.Platform.Models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.passwordmanager.User.Models.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPlatformByUserIdModel {
    private Long platform_id;
    private String description;
    private String platform_name;
    private String url;
    private long userId;
}
