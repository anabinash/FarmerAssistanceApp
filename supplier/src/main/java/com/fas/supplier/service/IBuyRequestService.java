package com.fas.supplier.service;

import com.fas.supplier.dtos.AddBuyRequest;
import com.fas.supplier.dtos.BuyRequestDetails;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Transactional
@Validated
public interface IBuyRequestService {

    BuyRequestDetails getBuyRequestsById(@Min(1) Long buyRequestId);

    BuyRequestDetails sendBuyRequest(@Valid AddBuyRequest addBuyRequest);

    List<BuyRequestDetails> getBuyRequestByProductId(@Min(1) Long productId);

    List<BuyRequestDetails> getBuyRequestBySupplier(@Min(1) Long supplierId);

    BuyRequestDetails approveBuyRequest(@Min(1) Long buyRequestId);

    BuyRequestDetails rejectBuyRequest(@Min(1) Long buyRequestId);

}
