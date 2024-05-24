package org.example.passwordmanager.User.Commands.UpdateUser;

import org.example.passwordmanager.User.Models.UpdateUserModel;
import org.example.passwordmanager.User.Models.User;
import org.example.passwordmanager.User.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUser implements  IUpdateUser{

    @Autowired
    private UserRepository _repository;

    @Autowired
    private ModelMapper _mapper;


    @Override
    public UpdateUserModel execute(UpdateUserModel model) {

        User existingUser = _repository.findById(model.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found with id: " + model.getUserId()));

        _mapper.map(model, existingUser);
        _repository.save(existingUser);

        return model;
    }
}
