package org.example.passwordmanager.Password.Commands.CreatePassword;

import jakarta.persistence.EntityManager;
import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Password.Models.CreatePasswordModel;
import org.example.passwordmanager.Password.Models.Password;
import org.example.passwordmanager.Password.Repository.PasswordRepository;
import org.example.passwordmanager.Platform.Models.Platform;
import org.example.passwordmanager.User.Models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreatePassword implements ICreatePassword {

    @Autowired
    private PasswordRepository _repository;
    @Autowired
    private EntityManager entityManager;

    public CreatePasswordModel Execute(CreatePasswordModel model){

        User user = entityManager.getReference(User.class, model.getUserId());
        Platform platform = entityManager.getReference(Platform.class, model.getPlatformId());
        Category category = entityManager.getReference(Category.class, model.getCategoryId());

        Password newPassword = new Password();
        newPassword.setUser(user);
        newPassword.setPlatform(platform);
        newPassword.setCategory(category);
        newPassword.setPlatformUsername(model.getPlatformUsername());
        newPassword.setPassword(model.getPassword());
        newPassword.setCreationDate(LocalDateTime.now());

        _repository.save(newPassword);

        return model;
    }

}
