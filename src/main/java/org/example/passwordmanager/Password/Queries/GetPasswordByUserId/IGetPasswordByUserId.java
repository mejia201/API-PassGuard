package org.example.passwordmanager.Password.Queries.GetPasswordByUserId;

import java.util.List;

public interface IGetPasswordByUserId {
    List<GetPasswordByUserId> execute(Long userId);
}
