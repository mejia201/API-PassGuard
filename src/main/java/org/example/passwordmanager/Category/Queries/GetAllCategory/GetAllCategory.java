package org.example.passwordmanager.Category.Queries.GetAllCategory;

import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Category.Models.GetAllCategoryModel;
import org.example.passwordmanager.Category.Repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllCategory implements IGetAllCategory{

    @Autowired
    private CategoryRepository _repository;

    @Autowired
    private ModelMapper _mapper;

    public List<GetAllCategoryModel> execute(){
        List<Category> listEntity = _repository.findAll();
        return listEntity.stream()
                .map(category -> _mapper.map(category, GetAllCategoryModel.class))
                .collect(Collectors.toList());
    }

}
