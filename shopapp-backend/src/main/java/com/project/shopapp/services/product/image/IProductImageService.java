package com.project.shopapp.services.product.image;

import com.project.shopapp.models.ProductImage;

public interface IProductImageService {
    ProductImage deleteProductImage(Long id) throws Exception;
}
