package org.example.passwordmanager.AppConfiguration;

import org.example.passwordmanager.ResponseApi.Model.BaseResponseModel;
import org.example.passwordmanager.ResponseApi.Service.ResponseApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponseModel> handleException(Exception ex) {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
