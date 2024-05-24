package org.example.passwordmanager.Category.Commands.DeleteCategory;

import org.example.passwordmanager.Category.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategory implements IDeleteCategory{


    @Autowired
    private CategoryRepository _repository;

    public void execute(Long categoryId) {
        _repository.deleteById(categoryId);
    }
}
