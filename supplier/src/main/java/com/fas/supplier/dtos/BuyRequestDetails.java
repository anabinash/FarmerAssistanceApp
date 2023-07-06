package com.fas.supplier.dtos;

public class BuyRequestDetails {

    private Long id;
    private Double askedPrice;
    private String requestStatus;

    private Long productId;
    private String productName;
    private Long productquantity;
    private Double sellingPrice;
    private Double buyingPrice;

    private Long farmerId;
    private String farmerFirstName;
    private String farmerLastName;
    private Long farmerPincode;
    private String farmerPhnNumber;

    private Long supplierId;
    private String supplierFirstName;
    private String supplierLastName;
    private Long supplierPincode;
    private String supplierPhnNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAskedPrice() {
        return askedPrice;
    }

    public void setAskedPrice(Double askedPrice) {
        this.askedPrice = askedPrice;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(Long productquantity) {
        this.productquantity = productquantity;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }

    public String getFarmerFirstName() {
        return farmerFirstName;
    }

    public void setFarmerFirstName(String farmerFirstName) {
        this.farmerFirstName = farmerFirstName;
    }

    public String getFarmerLastName() {
        return farmerLastName;
    }

    public void setFarmerLastName(String farmerLastName) {
        this.farmerLastName = farmerLastName;
    }

    public Long getFarmerPincode() {
        return farmerPincode;
    }

    public void setFarmerPincode(Long farmerPincode) {
        this.farmerPincode = farmerPincode;
    }

    public String getFarmerPhnNumber() {
        return farmerPhnNumber;
    }

    public void setFarmerPhnNumber(String farmerPhnNumber) {
        this.farmerPhnNumber = farmerPhnNumber;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierFirstName() {
        return supplierFirstName;
    }

    public void setSupplierFirstName(String supplierFirstName) {
        this.supplierFirstName = supplierFirstName;
    }

    public String getSupplierLastName() {
        return supplierLastName;
    }

    public void setSupplierLastName(String supplierLastName) {
        this.supplierLastName = supplierLastName;
    }

    public Long getSupplierPincode() {
        return supplierPincode;
    }

    public void setSupplierPincode(Long supplierPincode) {
        this.supplierPincode = supplierPincode;
    }

    public String getSupplierPhnNumber() {
        return supplierPhnNumber;
    }

    public void setSupplierPhnNumber(String supplierPhnNumber) {
        this.supplierPhnNumber = supplierPhnNumber;
    }


}
