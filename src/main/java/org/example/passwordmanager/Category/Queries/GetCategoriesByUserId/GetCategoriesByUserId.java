package org.example.passwordmanager.Category.Queries.GetCategoriesByUserId;

import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Category.Models.GetCategoriesByUserIdModel;
import org.example.passwordmanager.Category.Repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetCategoriesByUserId implements IGetCategoriesByUserId {
    @Autowired
    private CategoryRepository _repository;
    @Autowired
    private ModelMapper _mapper;

    public List<GetCategoriesByUserIdModel> execute(Long userId){

        List<Category> listEntity = _repository.findByUserId(userId);

        return listEntity.stream()
                .map(category -> _mapper.map(category, GetCategoriesByUserIdModel.class))
                .collect(Collectors.toList());
    }
}
