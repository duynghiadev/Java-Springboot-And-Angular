package com.project.shopapp.controllers;


import com.project.shopapp.models.ProductImage;
import com.project.shopapp.responses.ResponseObject;
import com.project.shopapp.services.product.ProductService;
import com.project.shopapp.services.product.image.IProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/product_images")
//@Validated
//Dependency Injection
@RequiredArgsConstructor
public class ProductImageController {
    private final IProductImageService productImageService;
    private final ProductService productService;
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) throws Exception {
        ProductImage productImage = productImageService.deleteProductImage(id);
        if(productImage != null){
            productService.deleteFile(productImage.getImageUrl());
        }
        return ResponseEntity.ok().body(
                ResponseObject.builder()
                        .message("Delete product image successfully")
                        .data(productImage)
                        .status(HttpStatus.OK)
                        .build()
        );
    }
}
