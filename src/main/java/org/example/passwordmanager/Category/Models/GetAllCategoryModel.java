package org.example.passwordmanager.Category.Models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllCategoryModel {
    private Long categoryId;
    private String categoryName;
    private String description;
}
