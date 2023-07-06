package com.fas.supplier.repository;

import com.fas.supplier.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("FROM Supplier WHERE username = :username")
    List<Supplier> findByUsername(@Param("username") String username);

}
