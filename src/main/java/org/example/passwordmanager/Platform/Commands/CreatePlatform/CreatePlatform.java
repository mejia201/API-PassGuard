package org.example.passwordmanager.Platform.Commands.CreatePlatform;

import org.example.passwordmanager.Platform.Models.CreatePlatformModel;
import org.example.passwordmanager.Platform.Models.Platform;
import org.example.passwordmanager.Platform.Repository.PlatformRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePlatform implements ICreatePlatform{
    @Autowired
    private PlatformRepository _repository;

    @Autowired
    private ModelMapper _mapper;

    public CreatePlatformModel execute(CreatePlatformModel model){
        Platform platform = _mapper.map(model, Platform.class);

        _repository.save(platform);
        return model;
    }
}
