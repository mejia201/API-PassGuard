package org.example.passwordmanager.ResponseApi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponseModel {
    private int statusCode;
    private boolean success;
    private String message;
    private Object data;
}
