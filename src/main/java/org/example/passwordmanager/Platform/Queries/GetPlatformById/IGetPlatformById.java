package org.example.passwordmanager.Platform.Queries.GetPlatformById;

import org.example.passwordmanager.Platform.Models.GetPlatformByIdModel;

public interface IGetPlatformById {
    GetPlatformByIdModel execute(Long platformId);
}
