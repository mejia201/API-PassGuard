package org.example.passwordmanager.Platform.Queries.GetPlatformById;

import org.example.passwordmanager.Platform.Models.GetPlatformByIdModel;
import org.example.passwordmanager.Platform.Models.Platform;
import org.example.passwordmanager.Platform.Repository.PlatformRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetPlatformById implements  IGetPlatformById{

    @Autowired
    private PlatformRepository _repository;

    @Autowired
    private ModelMapper _mapper;

    @Override
    public GetPlatformByIdModel execute(Long platformId) {
        Platform platformEntity = _repository.findById(platformId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + platformId));
        return _mapper.map(platformEntity, GetPlatformByIdModel.class);
    }
}
