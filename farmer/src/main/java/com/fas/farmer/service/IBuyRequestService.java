package com.fas.farmer.service;

import com.fas.farmer.dtos.BuyRequestDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import java.util.List;

@Validated
@Service
public interface IBuyRequestService {
    public List<BuyRequestDetails> getRequestForProductId(@Min(1) Long productId);

    public BuyRequestDetails approveRequest(@Min(1) Long requestId);

    public BuyRequestDetails rejectRequest(@Min(1) Long requestId);
}
