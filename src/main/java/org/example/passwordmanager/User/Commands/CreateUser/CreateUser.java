package org.example.passwordmanager.User.Commands.CreateUser;

import org.example.passwordmanager.User.Models.CreateUserModel;
import org.example.passwordmanager.User.Models.User;
import org.example.passwordmanager.User.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser implements  ICreateUser{

    @Autowired
    private UserRepository _repository;

    @Autowired
    private ModelMapper _mapper;


    @Override
    public CreateUserModel execute(CreateUserModel model) {
        User user = _mapper.map(model, User.class);
        _repository.save(user);

        return model;
    }
}
