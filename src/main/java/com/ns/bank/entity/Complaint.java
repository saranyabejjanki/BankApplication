package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="complaint")
public class Complaint  implements Serializable {

    private   Long id;
    private String description;
    private Status status;
    private Date raisedDate;
    private Date updatedDate;

    public Complaint() {
    }

    public Complaint(Long id, String description, Status status, Date raisedDate, Date updatedDate) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.raisedDate = raisedDate;
        this.updatedDate = updatedDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(cascade=CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRaisedDate() {
        return raisedDate;
    }

    public void setRaisedDate(Date raisedDate) {
        this.raisedDate = raisedDate;
    }

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
