package com.project.shopapp.controllers;

import com.project.shopapp.models.Category;
import com.project.shopapp.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/healthcheck")
@AllArgsConstructor
public class HealthCheckController {
    private final CategoryService categoryService;
    @GetMapping("/health")
    public ResponseEntity<?> healthCheck() {
        // Perform additional health checks here
        try {
            List<Category> categories = categoryService.getAllCategories();
            return ResponseEntity.ok("ok");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("failed");
        }
    }
}
