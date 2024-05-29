package org.example.passwordmanager.Password.Queries.GetPasswordByUserId;

import org.example.passwordmanager.Password.Models.GetPasswordByUserIdModel;

import java.util.List;

public interface IGetPasswordByUserId {
    List<GetPasswordByUserIdModel> execute(Long userId);
}
