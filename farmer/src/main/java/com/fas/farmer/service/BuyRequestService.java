package com.fas.farmer.service;

import com.fas.farmer.dtos.BuyRequestDetails;
import com.fas.farmer.dtos.ProductDetails;
import com.fas.farmer.dtos.SellProductRequest;
import com.fas.farmer.dtos.UserDetails;
import com.fas.farmer.entities.Farmer;
import com.fas.farmer.entities.Product;
import com.fas.farmer.exceptions.FarmerNotFoundException;
import com.fas.farmer.exceptions.ProductNotFoundException;
import com.fas.farmer.repository.IFarmersRepository;
import com.fas.farmer.repository.IProductRepository;
import com.fas.farmer.utils.FarmersUtil;
import com.fas.farmer.utils.BuyRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BuyRequestService implements IBuyRequestService {

    @Autowired
    private BuyRequestUtil buyRequestUtil;
    @Autowired
    private FarmersUtil farmersUtil;

    @Autowired
    private IFarmersRepository farmersRepository;
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductService iProductService;
                              
    @Override  
    public List<BuyRequestDetails> getRequestForProductId(Long productId) {
         
        Product product = getProductFromId(productId);
        Farmer farmer = getFarmerFromId(product.getFarmerId());
        UserDetails userDetails = farmersUtil.getUserDetails(farmer.getUsername());
        farmersUtil.isFarmerLoggedIn(userDetails);
               
        return buyRequestUtil.getRequestForProductId(productId);
    }

    @Override
    public BuyRequestDetails approveRequest(Long requestId) {
        BuyRequestDetails buyRequestDetails = buyRequestUtil.approveRequest(requestId);

        Optional<Product> productOptional = productRepository.findById(buyRequestDetails.getProductId());
        if (!productOptional.isPresent())
            throw new ProductNotFoundException("Product not found for id: " + buyRequestDetails.getProductId());
        Product product = productOptional.get();
        SellProductRequest sellProductRequest = new SellProductRequest();
        sellProductRequest.setProductId(product.getId());
        sellProductRequest.setSupplierId(buyRequestDetails.getSupplierId());
        sellProductRequest.setBuyingPrice(buyRequestDetails.getAskedPrice());
        ProductDetails productDetails = iProductService.sellProduct(sellProductRequest);

        buyRequestDetails.setBuyingPrice(productDetails.getBuyingPrice());

        return buyRequestDetails;
    }

    @Override
    public BuyRequestDetails rejectRequest(Long requestId) {
        return buyRequestUtil.cancelRequest(requestId);
    }

    private Farmer getFarmerFromId(Long farmerId) {
        Optional<Farmer> farmerOptional = farmersRepository.findById(farmerId);
        if (!farmerOptional.isPresent())
            throw new FarmerNotFoundException("No farmer found for id: " + farmerId);
        return farmerOptional.get();
    }

    private Product getProductFromId(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (!productOptional.isPresent())
            throw new ProductNotFoundException("No product found for id: " + productId);
        return productOptional.get();
    }
}
