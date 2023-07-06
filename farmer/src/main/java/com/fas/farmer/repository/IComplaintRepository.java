package com.fas.farmer.repository;

import com.fas.farmer.entities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComplaintRepository extends JpaRepository<Complaint, Long> {
}
