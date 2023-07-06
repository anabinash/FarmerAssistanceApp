package com.fas.supplier.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddBuyRequest {

    @NotNull
    @Min(1)
    private Long productId;
    @NotNull
    @Min(1)
    private Long supplierId;
    @NotNull
    @Min(1)
    private Double askedPrice;

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
}
