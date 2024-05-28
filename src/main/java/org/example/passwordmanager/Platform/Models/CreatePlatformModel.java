package org.example.passwordmanager.Platform.Models;

import lombok.Data;
import org.example.passwordmanager.User.Models.User;

@Data
public class CreatePlatformModel {
    private String description;
    private String platform_name;
    private String url;
    private long userId;
}
