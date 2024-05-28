package org.example.passwordmanager.Dashboard;

import org.example.passwordmanager.ResponseApi.Model.BaseResponseModel;
import org.example.passwordmanager.ResponseApi.Service.DashboardService;
import org.example.passwordmanager.ResponseApi.Service.ResponseApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<BaseResponseModel> getDashboardCounts() {
        Map<String, Integer> counts = dashboardService.getDashboardCounts();
        BaseResponseModel response = ResponseApiService.response(HttpStatus.OK.value(), counts, "Dashboard counts retrieved successfully");
        return ResponseEntity.ok(response);
    }

}
