package org.example.passwordmanager.Category.Models;

import lombok.*;
import org.example.passwordmanager.User.Models.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCategoryByIdModel {
    private Long categoryId;
    private String categoryName;
    private String description;
    private long userId;
}
