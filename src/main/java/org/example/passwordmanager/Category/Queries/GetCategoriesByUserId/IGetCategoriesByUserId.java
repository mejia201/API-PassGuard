package org.example.passwordmanager.Category.Queries.GetCategoriesByUserId;

import java.util.List;

public interface IGetCategoriesByUserId {
    List<GetCategoriesByUserId> execute(Long userId);
}
