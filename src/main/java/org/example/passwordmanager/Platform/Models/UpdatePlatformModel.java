package org.example.passwordmanager.Platform.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class UpdatePlatformModel {
    private Long platform_id;
    private String description;
    private String platform_name;
    private String url;
}
