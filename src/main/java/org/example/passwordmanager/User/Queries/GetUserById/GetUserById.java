package org.example.passwordmanager.User.Queries.GetUserById;

import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Category.Models.GetCategoryByIdModel;
import org.example.passwordmanager.User.Models.GetUserByIdModel;
import org.example.passwordmanager.User.Models.User;
import org.example.passwordmanager.User.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserById implements IGetUserById{

    @Autowired
    private UserRepository _repository;

    @Autowired
    private ModelMapper _mapper;


    @Override
    public GetUserByIdModel execute(Long userId) {
        User userEntity = _repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return _mapper.map(userEntity, GetUserByIdModel.class);
    }
}
