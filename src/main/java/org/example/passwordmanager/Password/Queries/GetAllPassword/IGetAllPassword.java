package org.example.passwordmanager.Password.Queries.GetAllPassword;

import org.example.passwordmanager.Password.Models.GetAllPasswordModel;

import java.util.List;

public interface IGetAllPassword {
    List<GetAllPasswordModel> execute();
}
