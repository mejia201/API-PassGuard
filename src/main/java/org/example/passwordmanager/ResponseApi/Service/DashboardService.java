package org.example.passwordmanager.ResponseApi.Service;

import org.example.passwordmanager.Category.Repository.CategoryRepository;
import org.example.passwordmanager.Password.Repository.PasswordRepository;
import org.example.passwordmanager.Platform.Repository.PlatformRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private PasswordRepository passwordRepository;


    public Map<String, Integer> getDashboardCounts() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("categoriesCount", (int) categoryRepository.count());
        counts.put("platformsCount", (int) platformRepository.count());
        counts.put("passwordsCount", (int) passwordRepository.count());
        return counts;
    }


}
