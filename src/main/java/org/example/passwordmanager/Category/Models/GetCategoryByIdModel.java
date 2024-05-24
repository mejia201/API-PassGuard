package org.example.passwordmanager.Category.Models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCategoryByIdModel {
    private Long categoryId;
    private String categoryName;
    private String description;
}
