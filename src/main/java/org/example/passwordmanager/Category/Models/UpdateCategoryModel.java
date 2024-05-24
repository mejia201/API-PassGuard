package org.example.passwordmanager.Category.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCategoryModel {
    private Long categoryId;
    private String categoryName;
    private String description;
}
