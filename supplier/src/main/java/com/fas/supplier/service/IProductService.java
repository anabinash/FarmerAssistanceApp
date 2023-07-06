package com.fas.supplier.service;

import com.fas.supplier.dtos.ProductDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Service
@Validated
public interface IProductService {
    List<ProductDetails> getProductsByPincode(@Min(1) @Max(999999) Long pincode);

    List<ProductDetails> getProductsByFarmerId(@Min(1) Long farmerId);

}
