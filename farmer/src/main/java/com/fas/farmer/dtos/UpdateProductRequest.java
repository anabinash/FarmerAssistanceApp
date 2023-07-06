package com.fas.farmer.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateProductRequest {

    @NotNull
    private Long productId;
    @NotNull
    @Min(1)
    private Long quantity;
    @NotNull
    @Min(1)
    private Double sellingPrice;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}


