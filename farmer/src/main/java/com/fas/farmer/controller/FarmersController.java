package com.fas.farmer.controller;

import com.fas.farmer.dtos.*;
import com.fas.farmer.entities.Complaint;
import com.fas.farmer.entities.Farmer;
import com.fas.farmer.service.IFarmersService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/farmers")
@Validated
public class FarmersController {

    @Autowired
    private IFarmersService farmerService;
    
    @PostMapping("/login") 
    public User login(@Valid @RequestBody LoginCredentials loginCredentials) {
    
        return farmerService.loginWithCredentials(loginCredentials);
    }

    @GetMapping("/logout/{username}")
    public User logout(@PathVariable @Length(min = 6, max = 16, message = "Username should be of length b/w 6 and 16") String username) {
        return farmerService.logout(username);
    }
 
    @PostMapping("/changePassword")
    public User changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        return farmerService.changePassword(changePasswordRequest);
    }
              
    @PostMapping("/updateFarmer")
    public Farmer updateSupplier(@Valid @RequestBody UpdateFarmer updateFarmer) {
        return farmerService.updateFarmer(updateFarmer);
    }

    @GetMapping("/findById/{farmerId}")
    public Farmer getById(@PathVariable @Min(1) Long farmerId) {
        return farmerService.getFarmerById(farmerId);
    }

    @PostMapping("/raiseComplaint")
    public Complaint addComplaint(@Valid @RequestBody AddComplaintRequest addComplaintRequest) {
        return farmerService.addComplaint(addComplaintRequest);
    }
}
