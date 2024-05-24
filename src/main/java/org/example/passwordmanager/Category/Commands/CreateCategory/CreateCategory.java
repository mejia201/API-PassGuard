package org.example.passwordmanager.Category.Commands.CreateCategory;

import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Category.Models.CreateCategoryModel;
import org.example.passwordmanager.Category.Repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCategory implements ICreateCategory {

    @Autowired
    private CategoryRepository _repository;

    @Autowired
    private ModelMapper _mapper;

    public CreateCategoryModel execute(CreateCategoryModel model){

        Category category = _mapper.map(model , Category.class);

        _repository.save(category);

        return model;
    }

}
