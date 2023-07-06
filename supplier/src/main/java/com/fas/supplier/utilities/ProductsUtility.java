package com.fas.supplier.utilities;

import com.fas.supplier.dtos.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class ProductsUtility {

    @Value("${products.baseUrl}")
    private String baseProductsUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<ProductDetails> getProductsByPincode(Long pincode) {
        String url = baseProductsUrl + "/findByPincode/" + pincode;
        ResponseEntity<ProductDetails[]> result = restTemplate.getForEntity(url, ProductDetails[].class);
        ProductDetails[] arrayList = result.getBody();
        List<ProductDetails> productDetailsList = new ArrayList<>();
        Collections.addAll(productDetailsList, arrayList);
        return productDetailsList;
    }

    public List<ProductDetails> getProductsByFarmerId(Long farmerId) {
        String url = baseProductsUrl + "/findByFarmerId/" + farmerId;
        ResponseEntity<ProductDetails[]> result = restTemplate.getForEntity(url, ProductDetails[].class);
        ProductDetails[] arrayList = result.getBody();
        List<ProductDetails> productDetailsList = new ArrayList<>();
        Collections.addAll(productDetailsList, arrayList);
        return productDetailsList;
    }
}
