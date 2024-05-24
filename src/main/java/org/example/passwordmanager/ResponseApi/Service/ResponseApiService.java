package org.example.passwordmanager.ResponseApi.Service;

import org.example.passwordmanager.ResponseApi.Model.BaseResponseModel;

public class ResponseApiService {
    public static BaseResponseModel response(int statusCode, Object data, String message) {
        boolean success = false;

        if (statusCode >= 200 && statusCode < 300) {
            success = true;
        }

        return new BaseResponseModel(statusCode, success, message, data);
    }
}
