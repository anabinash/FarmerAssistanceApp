package com.fas.supplier.service;

import com.fas.supplier.dtos.*;
import com.fas.supplier.entities.Supplier;
import com.fas.supplier.exceptions.SupplierNotFoundException;
import com.fas.supplier.repository.ISupplierRepository;
import com.fas.supplier.utilities.SupplierUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SupplierService implements ISupplierService {


    @Autowired
    private SupplierUtility suppliersUtil;

    @Autowired
    private ISupplierRepository suppliersRepository;

    @Override
    public User loginWithCredentials(LoginCredentials loginCredentials) {
        UserDetails userDetails = suppliersUtil.getUserDetails(loginCredentials.getUsername());

        suppliersUtil.isUserSupplier(userDetails);

        return suppliersUtil.sendLoginRequest(loginCredentials);
    }

    @Override
    public User logout(String username) {
        UserDetails userDetails = suppliersUtil.getUserDetails(username);

        suppliersUtil.isUserSupplier(userDetails);

        return suppliersUtil.sendLogoutRequest(username);
    }

    @Override
    public User changePassword(ChangePasswordRequest changPasswordRequest) {

        UserDetails userDetails = suppliersUtil.getUserDetails(changPasswordRequest.getUsername());
        suppliersUtil.isUserSupplier(userDetails);

        return suppliersUtil.sendChangePasswordRequest(changPasswordRequest);
    }

    @Override
    public Supplier updateSupplier(UpdateSupplier updateSupplier) {
        UserDetails userDetails = suppliersUtil.getUserDetails(updateSupplier.getUsername());
        suppliersUtil.isUserSupplier(userDetails);

        suppliersUtil.isSupplierLoggedIn(userDetails);

        List<Supplier> supplierList = suppliersRepository.findByUsername(updateSupplier.getUsername());
        Supplier supplier;
        if (supplierList.isEmpty())
            supplier = new Supplier();
        else
            supplier = supplierList.get(0);
        supplier.setUsername(updateSupplier.getUsername());
        supplier.setFirstName(updateSupplier.getFirstName());
        supplier.setLastName(updateSupplier.getLastName());
        supplier.setPincode(updateSupplier.getPincode());
        supplier.setPhnNumber(updateSupplier.getPhnNumber());
        return suppliersRepository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(Long supplierId) {
        Optional<Supplier> supplierOptional = suppliersRepository.findById(supplierId);
        if (!supplierOptional.isPresent())
            throw new SupplierNotFoundException("No supplier found for id: " + supplierId);
        Supplier supplier = supplierOptional.get();
        UserDetails userDetails = suppliersUtil.getUserDetails(supplier.getUsername());
        suppliersUtil.isSupplierLoggedIn(userDetails);
        return supplier;
    }

}
