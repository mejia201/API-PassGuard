package org.example.passwordmanager.Category.Queries.GetCategoriesByUserId;

import org.example.passwordmanager.Category.Models.GetCategoriesByUserIdModel;

import java.util.List;

public interface IGetCategoriesByUserId {
    List<GetCategoriesByUserIdModel> execute(Long userId);
}
