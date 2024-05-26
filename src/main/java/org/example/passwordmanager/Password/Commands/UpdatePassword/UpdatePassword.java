package org.example.passwordmanager.Password.Commands.UpdatePassword;

import jakarta.persistence.EntityManager;
import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Password.Models.Password;
import org.example.passwordmanager.Password.Models.UpdatePasswordModel;
import org.example.passwordmanager.Password.Repository.PasswordRepository;
import org.example.passwordmanager.Platform.Models.Platform;
import org.example.passwordmanager.User.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePassword implements IUpdatePassword{

    @Autowired
    private PasswordRepository _repository;

    @Autowired
    private EntityManager entityManager;

    public UpdatePasswordModel Execute(UpdatePasswordModel model){

        Password existingPassword = _repository.findById(model.getPasswordId()).orElseThrow(() -> new IllegalArgumentException("Invalid password ID"));

        existingPassword.setPlatformUsername(model.getPlatformUsername());
        existingPassword.setPassword(model.getPassword());

        if (model.getUserId() != null) {
            User user = entityManager.getReference(User.class, model.getUserId());
            existingPassword.setUser(user);
        }

        if (model.getPlatformId() != null) {
            Platform platform = entityManager.getReference(Platform.class, model.getPlatformId());
            existingPassword.setPlatform(platform);
        }

        if (model.getCategoryId() != null) {
            Category category = entityManager.getReference(Category.class, model.getCategoryId());
            existingPassword.setCategory(category);
        }

       _repository.save(existingPassword);

        return model;
    }

}

