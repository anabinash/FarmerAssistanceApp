package com.fas.supplier.entities;

import com.fas.supplier.constants.RequestStatus;

import javax.persistence.*;

@Entity
public class BuyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Long supplierId;
    @Column(nullable = false)
    private Double askedPrice;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Double getAskedPrice() {
        return askedPrice;
    }

    public void setAskedPrice(Double askedPrice) {
        this.askedPrice = askedPrice;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }


}
