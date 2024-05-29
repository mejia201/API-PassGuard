package org.example.passwordmanager.Password.Queries.GetAllPassword;

import org.example.passwordmanager.Password.Models.GetAllPasswordModel;
import org.example.passwordmanager.Password.Models.GetPasswordByUserIdModel;
import org.example.passwordmanager.Password.Models.Password;
import org.example.passwordmanager.Password.Repository.PasswordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllPassword implements IGetAllPassword {

    @Autowired
    private PasswordRepository _repository;

    @Autowired
    private ModelMapper _mapper;

    public List<GetAllPasswordModel> execute(){

        List<Password> passwords = _repository.findAll();

        return passwords.stream()
                .map(password -> _mapper.map(password, GetAllPasswordModel.class))
                .collect(Collectors.toList());

    }


}
