package org.example.passwordmanager.User;

import lombok.extern.slf4j.Slf4j;
import org.example.passwordmanager.Category.Models.CreateCategoryModel;
import org.example.passwordmanager.Category.Models.UpdateCategoryModel;
import org.example.passwordmanager.ResponseApi.Model.BaseResponseModel;
import org.example.passwordmanager.ResponseApi.Service.ResponseApiService;
import org.example.passwordmanager.User.Commands.CreateUser.ICreateUser;
import org.example.passwordmanager.User.Commands.DeleteUser.IDeleteUser;
import org.example.passwordmanager.User.Commands.UpdateUser.IUpdateUser;
import org.example.passwordmanager.User.Models.CreateUserModel;
import org.example.passwordmanager.User.Models.LoginRequestModel;
import org.example.passwordmanager.User.Models.UpdateUserModel;
import org.example.passwordmanager.User.Models.User;
import org.example.passwordmanager.User.Queries.GetAllUser.IGetAllUser;
import org.example.passwordmanager.User.Queries.GetUserById.IGetUserById;
import org.example.passwordmanager.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/Users")
public class UserController {

    @Autowired
    private ICreateUser createUserCommand;
    @Autowired
    private IUpdateUser updateUserCommand;
    @Autowired
    private IDeleteUser deleteUserCommand;
    @Autowired
    private IGetAllUser getAllUserQuery;
    @Autowired
    private IGetUserById getUserByIdQuery;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<BaseResponseModel> GetAllUsers() {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), getAllUserQuery.execute(), "Successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseModel> GetUserById(@PathVariable Long id) {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), getUserByIdQuery.execute(id), "Successfully");
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    public ResponseEntity<BaseResponseModel> createUser(@RequestBody CreateUserModel userModel) {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), createUserCommand.execute(userModel), "Successfully created user");
        return ResponseEntity.ok(response);
    }


    @PostMapping("/login")
    public ResponseEntity<BaseResponseModel> loginUser(@RequestBody LoginRequestModel loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail());


        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {

            Map<String, Object> userDetails = new HashMap<>();
            userDetails.put("id", user.getUserId());
            userDetails.put("email", user.getEmail());
            userDetails.put("username", user.getUsername());
            userDetails.put("password", user.getPassword());

            BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), userDetails, "Login successful");
            return ResponseEntity.ok(response);
        } else {

            BaseResponseModel response = ResponseApiService.response(HttpStatus.UNAUTHORIZED.value(), null, "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }



    @PutMapping()
    public ResponseEntity<BaseResponseModel> updateUser(@RequestBody UpdateUserModel userModel) {
        var updated = updateUserCommand.execute(userModel);
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), updated, "Successfully updated user");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseModel> deleteUser(@PathVariable Long id) {
        deleteUserCommand.execute(id);
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), null, "Successfully deleted user");
        return ResponseEntity.ok(response);
    }
}
