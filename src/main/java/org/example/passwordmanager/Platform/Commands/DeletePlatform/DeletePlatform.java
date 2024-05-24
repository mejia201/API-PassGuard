package org.example.passwordmanager.Platform.Commands.DeletePlatform;

import org.example.passwordmanager.Category.Commands.DeleteCategory.IDeleteCategory;
import org.example.passwordmanager.Platform.Repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePlatform implements IDeletePlatform {

    @Autowired
    private PlatformRepository _repository;

    @Override
    public void execute(Long platformId) {
        _repository.deleteById(platformId);
    }
}
