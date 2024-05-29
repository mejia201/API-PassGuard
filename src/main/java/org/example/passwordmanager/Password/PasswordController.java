package org.example.passwordmanager.Password;

import lombok.extern.slf4j.Slf4j;
import org.example.passwordmanager.Password.Commands.CreatePassword.ICreatePassword;
import org.example.passwordmanager.Password.Commands.DeletePassword.IDeletePassword;
import org.example.passwordmanager.Password.Commands.UpdatePassword.IUpdatePassword;
import org.example.passwordmanager.Password.Commands.UpdatePassword.UpdatePassword;
import org.example.passwordmanager.Password.Models.CreatePasswordModel;
import org.example.passwordmanager.Password.Models.UpdatePasswordModel;
import org.example.passwordmanager.Password.Queries.GetAllPassword.IGetAllPassword;
import org.example.passwordmanager.Password.Queries.GetPasswordByUserId.IGetPasswordByUserId;
import org.example.passwordmanager.ResponseApi.Model.BaseResponseModel;
import org.example.passwordmanager.ResponseApi.Service.ResponseApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/Passwords")
public class PasswordController {

    @Autowired
    private ICreatePassword createPasswordCommand;

    @Autowired
    private IUpdatePassword updatePasswordCommand;

    @Autowired
    private IDeletePassword deletePasswordCommand;

    @Autowired
    private IGetAllPassword getAllPasswordQuery;
    @Autowired
    private UpdatePassword updatePassword;
    @Autowired
    private IGetPasswordByUserId getPasswordByUserId;

    @GetMapping("/ByUserId/{userId}")
    public ResponseEntity<BaseResponseModel> GetCategoriesByUserId(@PathVariable Long userId) {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), getPasswordByUserId.execute(userId), "Successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<BaseResponseModel> GetAllPassword() {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), getAllPasswordQuery.execute(), "Successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<BaseResponseModel> createPassword(@RequestBody CreatePasswordModel model) {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), createPasswordCommand.Execute(model), "Successfully created password");
        return ResponseEntity.ok(response);
    }

    @PutMapping()
    public ResponseEntity<BaseResponseModel> updateCategory(@RequestBody UpdatePasswordModel model) {
        var updated = updatePassword.Execute(model);
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), updated, "Successfully updated password");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseModel> deleteCategory(@PathVariable Long id) {
        deletePasswordCommand.execute(id);
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), null, "Successfully deleted category");
        return ResponseEntity.ok(response);
    }

}
