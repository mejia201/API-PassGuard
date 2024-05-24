package org.example.passwordmanager.Category.Commands.UpdateCategory;

import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Category.Models.UpdateCategoryModel;
import org.example.passwordmanager.Category.Repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCategory implements IUpdateCategory{

    @Autowired
    private CategoryRepository _repository;

    @Autowired
    private ModelMapper _mapper;

    public UpdateCategoryModel execute(UpdateCategoryModel model) {

        Category existingCategory = _repository.findById(model.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + model.getCategoryId()));

        _mapper.map(model, existingCategory);

        _repository.save(existingCategory);

        return model;
    }


}
