package com.fas.farmer.entities;

import com.fas.farmer.constants.ComplaintStatus;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Complaint {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long farmerId;

    @Length(min=8, max=64, message = "Complaint description should be b/w 8 and 64 characters")
    private String complaintDescription;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ComplaintStatus status;

    public Complaint(Long farmerId, String complaintDescription, ComplaintStatus status) {
        this.farmerId = farmerId;
        this.complaintDescription = complaintDescription;
        this.status = status;
    }

    public Complaint() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return id.equals(complaint.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "Id=" + id +
                ", farmerId=" + farmerId +
                ", complaintDescription='" + complaintDescription + '\'' +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }
}
