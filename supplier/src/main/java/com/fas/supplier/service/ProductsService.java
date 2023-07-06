package com.fas.supplier.service;

import com.fas.supplier.dtos.ProductDetails;
import com.fas.supplier.utilities.ProductsUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductsService implements IProductService{

    @Autowired
    private ProductsUtility productsUtility;
    @Override
    public List<ProductDetails> getProductsByPincode(Long pincode) {
        return productsUtility.getProductsByPincode(pincode);
    }

    @Override
    public List<ProductDetails> getProductsByFarmerId(Long farmerId) {
        return productsUtility.getProductsByFarmerId(farmerId);
    }
}
