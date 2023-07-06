package com.fas.farmer.repository;

import com.fas.farmer.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//import java.util.Optional;

public interface IFarmersRepository extends JpaRepository<Farmer,Long> {

    @Query("FROM Farmer WHERE username = :username")
    List<Farmer> findByUsername(@Param("username") String username);
}
