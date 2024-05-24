package org.example.passwordmanager.User.Commands.DeleteUser;

import org.example.passwordmanager.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUser implements IDeleteUser{

    @Autowired
    private UserRepository _repository;


    @Override
    public void execute(Long userId) {
        _repository.deleteById(userId);

    }
}
