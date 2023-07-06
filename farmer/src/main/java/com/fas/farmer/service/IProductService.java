package com.fas.farmer.service;

import com.fas.farmer.dtos.AddProductRequest;
import com.fas.farmer.dtos.ProductDetails;
import com.fas.farmer.dtos.SellProductRequest;
import com.fas.farmer.dtos.UpdateProductRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@Service
public interface IProductService {
    ProductDetails addProduct(@Valid AddProductRequest addProductRequest);

    ProductDetails getProductDetails(@Min(1) Long productId);

    ProductDetails updateProduct(@Valid UpdateProductRequest updateProduct);

    ProductDetails sellProduct(@Valid SellProductRequest sellProduct);

    List<ProductDetails> getProductsByPincode(@Min(1) @Max(999999) Long pincode);

    List<ProductDetails> getProductsByFarmerId(@Min(1) Long farmerId);
}
