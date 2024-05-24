package org.example.passwordmanager.User.Queries.GetAllUser;

import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Category.Models.GetAllCategoryModel;
import org.example.passwordmanager.User.Models.GetAllUserModel;
import org.example.passwordmanager.User.Models.User;
import org.example.passwordmanager.User.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllUser implements IGetAllUser{

    @Autowired
    private UserRepository _repository;

    @Autowired
    private ModelMapper _mapper;


    @Override
    public List<GetAllUserModel> execute() {
        List<User> listEntity = _repository.findAll();
        return listEntity.stream()
                .map(user -> _mapper.map(user, GetAllUserModel.class))
                .collect(Collectors.toList());
    }
}
