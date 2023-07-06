package com.fas.supplier.utilities;

import com.fas.supplier.dtos.BuyRequestDetails;
import com.fas.supplier.dtos.ProductDetails;
import com.fas.supplier.entities.BuyRequest;
import com.fas.supplier.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class BuyRequestUtility {

    @Value("${admins.baseUrl}")
    private String baseAdminsUrl;
    @Value("${farmers.baseUrl}")
    private String baseFarmersUrl;

    @Value("${products.baseUrl}")
    private String baseProductsUrl;
    @Autowired
    private RestTemplate restTemplate;


    public ProductDetails getProductDetailsById(Long productId) {
        String url = baseProductsUrl + "/findById/" + productId;
        ResponseEntity<ProductDetails> result = restTemplate.getForEntity(url, ProductDetails.class);
        return result.getBody();
    }

    public BuyRequestDetails toBuyRequestDetails(BuyRequest buyRequest, Supplier supplier) {
        BuyRequestDetails buyRequestDetails = new BuyRequestDetails();
        ProductDetails productDetails = getProductDetailsById(buyRequest.getProductId());
        buyRequestDetails.setId(buyRequest.getId());
        buyRequestDetails.setAskedPrice(buyRequest.getAskedPrice());
        buyRequestDetails.setRequestStatus(buyRequest.getRequestStatus().toString());

        buyRequestDetails.setProductId(buyRequest.getProductId());
        buyRequestDetails.setProductName(productDetails.getName());
        buyRequestDetails.setProductquantity(productDetails.getQuantity());
        buyRequestDetails.setSellingPrice(productDetails.getSellingPrice());
        buyRequestDetails.setBuyingPrice(productDetails.getBuyingPrice());

        buyRequestDetails.setFarmerId(productDetails.getFarmerId());
        buyRequestDetails.setFarmerFirstName(productDetails.getFarmerFirstName());
        buyRequestDetails.setFarmerLastName(productDetails.getFarmerLastName());
        buyRequestDetails.setFarmerPincode(productDetails.getFarmerPincode());
        buyRequestDetails.setFarmerPhnNumber(productDetails.getFarmerPhnNumber());

        buyRequestDetails.setSupplierId(buyRequest.getSupplierId());
        buyRequestDetails.setSupplierFirstName(supplier.getFirstName());
        buyRequestDetails.setSupplierLastName(supplier.getLastName());
        buyRequestDetails.setSupplierPincode(supplier.getPincode());
        buyRequestDetails.setSupplierPhnNumber(supplier.getPhnNumber());

        return buyRequestDetails;
    }


}
