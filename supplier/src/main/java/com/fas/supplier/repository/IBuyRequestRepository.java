package com.fas.supplier.repository;

import com.fas.supplier.entities.BuyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBuyRequestRepository extends JpaRepository<BuyRequest, Long> {
    @Query("FROM BuyRequest WHERE supplierId = :supplierId")
    List<BuyRequest> getBuyRequestsBySupplierId(@Param("supplierId") Long supplierId);

    @Query("FROM BuyRequest WHERE productId = :productId")
    List<BuyRequest> getBuyRequestByProductId(@Param("productId") Long productId);

    @Query("FROM BuyRequest WHERE supplierId = :supplierId")
    List<BuyRequest> getBuyRequestBySupplierId(@Param("supplierId") Long supplierId);
}
