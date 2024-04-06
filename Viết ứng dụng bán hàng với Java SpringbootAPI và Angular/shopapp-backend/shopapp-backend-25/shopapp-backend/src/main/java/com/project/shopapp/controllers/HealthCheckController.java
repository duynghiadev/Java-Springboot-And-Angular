package com.project.shopapp.controllers;

import com.project.shopapp.models.Category;
import com.project.shopapp.services.category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.net.InetAddress;

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
            // Get the computer name
            String computerName = InetAddress.getLocalHost().getHostName();        
            return ResponseEntity.ok("ok, Computer Name: " + computerName);            
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("failed");
        }
    }
}
