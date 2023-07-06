package com.fas.farmer.controller;

import com.fas.farmer.dtos.*;
import com.fas.farmer.service.IProductService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
public class ProductsController {

    @Autowired
    private IProductService productService;

    @PostMapping("/add")
    public ProductDetails addProducts(@Valid @RequestBody AddProductRequest addProductRequest) {
        return productService.addProduct(addProductRequest);
    }

    @PostMapping("/update")
    public ProductDetails updateProduct(@Valid @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.updateProduct(updateProductRequest);
    }

    @GetMapping("/findById/{productId}")
    public ProductDetails getProductById(@PathVariable Long productId) {
        return productService.getProductDetails(productId);
    }
    @Hidden
    @GetMapping("/findByPincode/{pincode}")
    public List<ProductDetails> getProductsByPincode(@PathVariable Long pincode) {
        return productService.getProductsByPincode(pincode);
    }

    @GetMapping("/findByFarmerId/{farmerId}")
    public List<ProductDetails> getProductsByFarmerId(@PathVariable Long farmerId) {
        return productService.getProductsByFarmerId(farmerId);
    }
}
