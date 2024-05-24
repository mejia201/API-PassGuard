package org.example.passwordmanager.Category.Queries.GetCategoryById;

import org.example.passwordmanager.Category.Models.GetCategoryByIdModel;

public interface IGetCategoryById {
    GetCategoryByIdModel execute(Long categoryId);
}
