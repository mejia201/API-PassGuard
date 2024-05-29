package org.example.passwordmanager.Platform.Queries.GetPlatformByUserId;

import org.example.passwordmanager.Platform.Models.GetPlatformByUserIdModel;

import java.util.List;

public interface IGetPlatformByUserId {
    List<GetPlatformByUserIdModel> execute(Long userId);
}
