package com.fas.farmer.utils;

import com.fas.farmer.dtos.BuyRequestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BuyRequestUtil {
          
    @Autowired
    private RestTemplate restTemplate;
      
    @Value("${buyRequest.baseUrl}")
    private String baseBuyRequestUrl;
    public List<BuyRequestDetails> getRequestForProductId(Long productId) {
        String url = baseBuyRequestUrl + "/getByProductId/" + productId;
        ResponseEntity<BuyRequestDetails[]> result = restTemplate.getForEntity(url, BuyRequestDetails[].class);
        BuyRequestDetails[] arrayList = result.getBody();
        List<BuyRequestDetails> buyRequestDetailsList = new ArrayList<>();
        Collections.addAll(buyRequestDetailsList, arrayList);
        return buyRequestDetailsList;
    }
                                      
    public List<BuyRequestDetails> getRequestForFarmerId(Long farmerId) {
        String url = baseBuyRequestUrl +"/getByFarmerId/" + farmerId;
        ResponseEntity<BuyRequestDetails[]> result = restTemplate.getForEntity(url, BuyRequestDetails[].class);
        BuyRequestDetails[] arrayList = result.getBody();
        List<BuyRequestDetails> buyRequestDetailsList = new ArrayList<>();
        Collections.addAll(buyRequestDetailsList, arrayList);
        return buyRequestDetailsList;
    }

    public BuyRequestDetails approveRequest(Long requestId) {

        String url = baseBuyRequestUrl +"/approveRequest/" + requestId;
        return restTemplate.getForEntity(url, BuyRequestDetails.class).getBody();
    }

    public BuyRequestDetails cancelRequest(Long requestId) {
        String url = baseBuyRequestUrl +"/rejectRequest/" + requestId;
        return restTemplate.getForEntity(url, BuyRequestDetails.class).getBody();
    }
}
