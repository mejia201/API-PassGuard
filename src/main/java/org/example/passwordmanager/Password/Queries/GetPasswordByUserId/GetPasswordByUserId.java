package org.example.passwordmanager.Password.Queries.GetPasswordByUserId;

import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Category.Models.GetCategoryByIdModel;
import org.example.passwordmanager.Category.Queries.GetCategoriesByUserId.GetCategoriesByUserId;
import org.example.passwordmanager.Category.Repository.CategoryRepository;
import org.example.passwordmanager.Password.Models.Password;
import org.example.passwordmanager.Password.Repository.PasswordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetPasswordByUserId implements IGetPasswordByUserId{
    @Autowired
    private PasswordRepository _repository;

    @Autowired
    private ModelMapper _mapper;

    public List<GetPasswordByUserId> execute(Long userId){

        List<Password> listEntity = _repository.findByUserId(userId);

        return listEntity.stream()
                .map(category -> _mapper.map(category, GetPasswordByUserId.class))
                .collect(Collectors.toList());
    }
}
