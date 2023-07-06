package com.fas.farmer.controller;

import com.fas.farmer.dtos.BuyRequestDetails;
import com.fas.farmer.service.BuyRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buyRequests")
@Validated
public class BuyRequestController {

    @Autowired
    private BuyRequestService buyRequestService;

    @GetMapping("/getByProductId/{productId}")
    public List<BuyRequestDetails> getProductById(@PathVariable Long productId) {
        return buyRequestService.getRequestForProductId(productId);
    }

    @GetMapping("/approveRequest/{requestId}")
    public BuyRequestDetails approveRequest(@PathVariable Long requestId){
        return buyRequestService.approveRequest(requestId);
    }

    @GetMapping("/cancelRequest/{requestId}")
    public BuyRequestDetails cancelRequest(@PathVariable Long requestId){
        return buyRequestService.rejectRequest(requestId);
    }
}
