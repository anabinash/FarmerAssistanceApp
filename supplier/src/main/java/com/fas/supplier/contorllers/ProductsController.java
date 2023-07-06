package com.fas.supplier.contorllers;

import com.fas.supplier.dtos.ProductDetails;
import com.fas.supplier.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/byPincode/{pincode}")
    public List<ProductDetails> getProductsByPincode(@PathVariable Long pincode){
        return productsService.getProductsByPincode(pincode);
    }

    @GetMapping("/byFarmerId/{farmerId}")
    public List<ProductDetails> getProductsByFarmerId(@PathVariable Long farmerId){
        return productsService.getProductsByFarmerId(farmerId);
    }
}
