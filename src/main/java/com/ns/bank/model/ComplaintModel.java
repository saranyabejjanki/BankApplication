package com.ns.bank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class ComplaintModel implements Serializable {

    private   Long id;
    private String description;
    private StatusModel statusModel;
    private Date raisedDate;
    private Date updatedDate;

    public ComplaintModel() {
    }

    public ComplaintModel(Long id, String description, StatusModel statusModel, Date raisedDate, Date updatedDate) {
        this.id = id;
        this.description = description;
        this.statusModel = statusModel;
        this.raisedDate = raisedDate;
        this.updatedDate = updatedDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        this.statusModel = statusModel;
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
}
