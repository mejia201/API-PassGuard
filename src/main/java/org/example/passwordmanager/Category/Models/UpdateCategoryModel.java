package org.example.passwordmanager.Category.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.passwordmanager.User.Models.User;

@Data
@AllArgsConstructor
public class UpdateCategoryModel {
    private Long categoryId;
    private String categoryName;
    private String description;
    private long userId;
}
