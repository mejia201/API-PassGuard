package org.example.passwordmanager.Password.Commands.DeletePassword;

import org.example.passwordmanager.Password.Repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePassword implements  IDeletePassword{

    @Autowired
    private PasswordRepository _repository;

    public void execute(Long passwordId) {
        _repository.deleteById(passwordId);
    }

}
