package com.fas.supplier.contorllers;

import com.fas.supplier.dtos.AddBuyRequest;
import com.fas.supplier.dtos.BuyRequestDetails;
import com.fas.supplier.service.IBuyRequestService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/buyRequest")
@Validated
public class BuyRequestController {

    @Autowired
    private IBuyRequestService buyRequestService;

    @PostMapping("/addRequest")
    public BuyRequestDetails getById(@Valid @RequestBody AddBuyRequest addBuyRequest) {
        return buyRequestService.sendBuyRequest(addBuyRequest);
    }

    @GetMapping("/getById/{buyRequestId}")
    public BuyRequestDetails getById(@PathVariable Long buyRequestId) {
        return buyRequestService.getBuyRequestsById(buyRequestId);
    }

    @Hidden
    @GetMapping("/getByProductId/{productId}")
    public List<BuyRequestDetails> getByProductId(@PathVariable Long productId) {
        return buyRequestService.getBuyRequestByProductId(productId);
    }

    @GetMapping("/getBySupplierId/{supplierId}")
    public List<BuyRequestDetails> getBySupplierId(@PathVariable Long supplierId) {
        return buyRequestService.getBuyRequestBySupplier(supplierId);
    }

    @Hidden
    @GetMapping("/approveRequest/{requestId}")
    public BuyRequestDetails approveRequest(@PathVariable Long requestId) {
        return buyRequestService.approveBuyRequest(requestId);
    }

    @Hidden
    @GetMapping("/rejectRequest/{requestId}")
    public BuyRequestDetails rejectRequest(@PathVariable Long requestId) {
        return buyRequestService.rejectBuyRequest(requestId);
    }
}
