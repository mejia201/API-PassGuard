package org.example.passwordmanager.Category.Queries.GetCategoryById;

import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Category.Models.GetCategoryByIdModel;
import org.example.passwordmanager.Category.Repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCategoryById implements IGetCategoryById {

    @Autowired
    private CategoryRepository _repository;

    @Autowired
    private ModelMapper _mapper;

    public GetCategoryByIdModel execute(Long categoryId){
        Category categoryEntity = _repository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));
        return _mapper.map(categoryEntity, GetCategoryByIdModel.class);
    }
}
