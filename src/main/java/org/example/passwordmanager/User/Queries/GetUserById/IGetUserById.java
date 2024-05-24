package org.example.passwordmanager.User.Queries.GetUserById;

import org.example.passwordmanager.User.Models.GetUserByIdModel;

public interface IGetUserById {
    GetUserByIdModel execute(Long userId);
}
