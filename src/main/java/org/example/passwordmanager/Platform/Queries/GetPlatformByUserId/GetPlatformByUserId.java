package org.example.passwordmanager.Platform.Queries.GetPlatformByUserId;


import org.example.passwordmanager.Password.Models.Password;
import org.example.passwordmanager.Password.Queries.GetPasswordByUserId.GetPasswordByUserId;
import org.example.passwordmanager.Platform.Models.GetPlatformByUserIdModel;
import org.example.passwordmanager.Platform.Models.Platform;
import org.example.passwordmanager.Platform.Repository.PlatformRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetPlatformByUserId implements IGetPlatformByUserId{

    @Autowired
    private PlatformRepository _repository;

    @Autowired
    private ModelMapper _mapper;

    public List<GetPlatformByUserIdModel> execute(Long userId){

        List<Platform> listEntity = _repository.findByUserId(userId);

        return listEntity.stream()
                .map(category -> _mapper.map(category, GetPlatformByUserIdModel.class))
                .collect(Collectors.toList());
    }
}
