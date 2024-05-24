package org.example.passwordmanager.Platform;

import lombok.extern.slf4j.Slf4j;
import org.example.passwordmanager.Category.Models.CreateCategoryModel;
import org.example.passwordmanager.Category.Models.UpdateCategoryModel;
import org.example.passwordmanager.Platform.Commands.CreatePlatform.ICreatePlatform;
import org.example.passwordmanager.Platform.Commands.DeletePlatform.IDeletePlatform;
import org.example.passwordmanager.Platform.Commands.UpdatePlatform.IUpdatePlatform;
import org.example.passwordmanager.Platform.Models.CreatePlatformModel;
import org.example.passwordmanager.Platform.Models.UpdatePlatformModel;
import org.example.passwordmanager.Platform.Queries.GetAllPlatform.IGetAllPlatform;
import org.example.passwordmanager.Platform.Queries.GetPlatformById.IGetPlatformById;
import org.example.passwordmanager.ResponseApi.Model.BaseResponseModel;
import org.example.passwordmanager.ResponseApi.Service.ResponseApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/Platforms")
public class PlatformController {

    @Autowired
    private ICreatePlatform createPlatformCommand;
    @Autowired
    private IUpdatePlatform updatePlatformCommand;
    @Autowired
    private IDeletePlatform deletePlatformcommand;
    @Autowired
    private IGetAllPlatform getAllPlatformQuery;
    @Autowired
    private IGetPlatformById getPlatformByIdQuery;


    @GetMapping
    public ResponseEntity<BaseResponseModel> GetAllPlatforms() {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), getAllPlatformQuery.execute(), "Successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseModel> GetPlatformById(@PathVariable Long id) {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), getPlatformByIdQuery.execute(id), "Successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<BaseResponseModel> createPlatform(@RequestBody CreatePlatformModel platformModel) {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), createPlatformCommand.execute(platformModel), "Successfully created platform");
        return ResponseEntity.ok(response);
    }

    @PutMapping()
    public ResponseEntity<BaseResponseModel> updatePlatform(@RequestBody UpdatePlatformModel platformModel) {
        var updated = updatePlatformCommand.execute(platformModel);
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), updated, "Successfully updated platform");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseModel> deletePlatform(@PathVariable Long id) {
        deletePlatformcommand.execute(id);
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), null, "Successfully deleted platform");
        return ResponseEntity.ok(response);
    }

}

