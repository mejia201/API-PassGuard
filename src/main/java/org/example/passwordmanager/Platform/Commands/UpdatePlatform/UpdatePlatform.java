package org.example.passwordmanager.Platform.Commands.UpdatePlatform;

import org.example.passwordmanager.Platform.Models.Platform;
import org.example.passwordmanager.Platform.Models.UpdatePlatformModel;
import org.example.passwordmanager.Platform.Repository.PlatformRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePlatform implements IUpdatePlatform{

    @Autowired
    private PlatformRepository _repository;

    @Autowired
    private ModelMapper _mapper;


    @Override
    public UpdatePlatformModel execute(UpdatePlatformModel model) {

        Platform existingPlatform = _repository.findById(model.getPlatform_id())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + model.getPlatform_id()));

        _mapper.map(model, existingPlatform);
        _repository.save(existingPlatform);
        return model;
    }
}
