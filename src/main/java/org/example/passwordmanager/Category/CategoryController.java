package org.example.passwordmanager.Category;

import lombok.extern.slf4j.Slf4j;
import org.example.passwordmanager.Category.Commands.CreateCategory.ICreateCategory;
import org.example.passwordmanager.Category.Commands.DeleteCategory.IDeleteCategory;
import org.example.passwordmanager.Category.Commands.UpdateCategory.IUpdateCategory;
import org.example.passwordmanager.Category.Models.CreateCategoryModel;
import org.example.passwordmanager.Category.Models.UpdateCategoryModel;
import org.example.passwordmanager.Category.Queries.GetAllCategory.IGetAllCategory;
import org.example.passwordmanager.Category.Queries.GetCategoryById.IGetCategoryById;
import org.example.passwordmanager.ResponseApi.Model.BaseResponseModel;
import org.example.passwordmanager.ResponseApi.Service.ResponseApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/Categories")
public class CategoryController {

    @Autowired
    private ICreateCategory createCategoryCommand;
    @Autowired
    private IUpdateCategory updateCategoryCommand;
    @Autowired
    private IDeleteCategory deleteCategoryCommand;
    @Autowired
    private IGetAllCategory getAllCategoryQuery;
    @Autowired
    private IGetCategoryById getCategoryByIdQuery;

    @GetMapping
    public ResponseEntity<BaseResponseModel> GetAllCategories() {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), getAllCategoryQuery.execute(), "Successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseModel> GetCategoryById(@PathVariable Long id) {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), getCategoryByIdQuery.execute(id), "Successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<BaseResponseModel> createCategory(@RequestBody CreateCategoryModel categoryModel) {
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), createCategoryCommand.execute(categoryModel), "Successfully created category");
        return ResponseEntity.ok(response);
    }

    @PutMapping()
    public ResponseEntity<BaseResponseModel> updateCategory(@RequestBody UpdateCategoryModel categoryModel) {
        var updated = updateCategoryCommand.execute(categoryModel);
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), updated, "Successfully updated category");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseModel> deleteCategory(@PathVariable Long id) {
        deleteCategoryCommand.execute(id);
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), null, "Successfully deleted category");
        return ResponseEntity.ok(response);
    }

}
