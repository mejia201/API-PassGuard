package org.example.passwordmanager.Platform.Models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllPlatformModel {
    private Long platform_id;
    private String description;
    private String platform_name;
    private String url;
}
