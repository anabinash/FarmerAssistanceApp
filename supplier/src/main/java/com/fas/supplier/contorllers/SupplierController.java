package com.fas.supplier.contorllers;

import com.fas.supplier.dtos.*;
import com.fas.supplier.entities.Supplier;
import com.fas.supplier.service.IBuyRequestService;
import com.fas.supplier.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/suppliers")
@Validated
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private IBuyRequestService buyRequestService;

    @PostMapping("/login")
    public User login(@Valid @RequestBody LoginCredentials loginCredentials) {
        return supplierService.loginWithCredentials(loginCredentials);
    }

    @GetMapping("/logout/{username}")
    public User logout(@PathVariable String username) {
        return supplierService.logout(username);
    }

    @PostMapping("/changePassword")
    public User changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        return supplierService.changePassword(changePasswordRequest);
    }

    @PostMapping("/updateSupplier")
    public Supplier updateSupplier(@Valid @RequestBody UpdateSupplier updateSupplier) {
        return supplierService.updateSupplier(updateSupplier);
    }

    @GetMapping("/findById/{id}")
    public Supplier findSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

}
