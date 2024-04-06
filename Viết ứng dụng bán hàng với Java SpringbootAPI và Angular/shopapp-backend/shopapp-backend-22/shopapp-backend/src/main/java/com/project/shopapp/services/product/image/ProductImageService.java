package com.project.shopapp.services.product.image;

import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.ProductImage;
import com.project.shopapp.repositories.ProductImageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductImageService implements IProductImageService{
    private final ProductImageRepository productImageRepository;
    @Override
    @Transactional
    public ProductImage deleteProductImage(Long id) throws Exception {
        Optional<ProductImage> productImage = productImageRepository.findById(id);
        if(productImage.isEmpty()) {
            throw new DataNotFoundException(
                    String.format("Cannot find product image with id: %ld", id)
            );
        }
        productImageRepository.deleteById(id);
        return productImage.get();
    }
}
