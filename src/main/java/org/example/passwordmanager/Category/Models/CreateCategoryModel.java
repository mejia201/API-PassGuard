package org.example.passwordmanager.Category.Models;

import lombok.Data;
import org.example.passwordmanager.User.Models.User;

@Data
public class CreateCategoryModel {
    private String categoryName;
    private String description;
    private User user;
}
