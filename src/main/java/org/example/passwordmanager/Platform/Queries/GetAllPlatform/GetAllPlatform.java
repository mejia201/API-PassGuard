package org.example.passwordmanager.Platform.Queries.GetAllPlatform;

import org.example.passwordmanager.Platform.Models.GetAllPlatformModel;
import org.example.passwordmanager.Platform.Models.Platform;
import org.example.passwordmanager.Platform.Repository.PlatformRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllPlatform implements IGetAllPlatform{

    @Autowired
    private PlatformRepository _repository;

    @Autowired
    private ModelMapper _mapper;


    @Override
    public List<GetAllPlatformModel> execute() {
        List<Platform> listEntity = _repository.findAll();
        return listEntity.stream()
                .map(platform -> _mapper.map(platform, GetAllPlatformModel.class))
                .collect(Collectors.toList());
    }
}
