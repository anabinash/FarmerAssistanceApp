package com.fas.farmer.repository;

import com.fas.farmer.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query("FROM Product WHERE farmerId = :farmerId")
    List<Product> getProductsByFarmerId(@Param("farmerId") Long farmerId);
}
