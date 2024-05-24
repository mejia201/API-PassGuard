package org.example.passwordmanager.User.Queries.GetAllUser;

import org.example.passwordmanager.User.Models.GetAllUserModel;

import java.util.List;

public interface IGetAllUser {
    List<GetAllUserModel> execute();
}
