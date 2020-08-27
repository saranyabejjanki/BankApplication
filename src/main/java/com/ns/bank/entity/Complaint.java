package com.ns.bank.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="complaint")
public class Complaint  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId")
    private Status status;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date raisedDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "accountNo")
    private Customer customer;

    public Complaint() {
    }

    public Complaint(Long id, String description, Status status, Date raisedDate, Date updatedDate,Customer customer) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.raisedDate = raisedDate;
        this.updatedDate = updatedDate;
        this.customer=customer;
    }


    public  Long getId() {
        return id;
    }

    public void setId( Long id) {
        this.id = id;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Date getRaisedDate() {
        return raisedDate;
    }

    public void setRaisedDate(Date raisedDate) {
        this.raisedDate = raisedDate;
    }


    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
