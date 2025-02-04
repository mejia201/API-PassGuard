package org.example.passwordmanager.Platform.Models;

import lombok.*;
import org.example.passwordmanager.User.Models.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetPlatformByIdModel {
    private Long platform_id;
    private String description;
    private String platform_name;
    private String url;
    private long userId;
}
