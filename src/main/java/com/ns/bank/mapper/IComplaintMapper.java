package com.ns.bank.mapper;

import com.ns.bank.entity.Address;
import com.ns.bank.entity.Complaint;
import com.ns.bank.model.AddressModel;
import com.ns.bank.model.ComplaintModel;

public interface IComplaintMapper {
    Complaint convertModelToEntity(ComplaintModel complainModel);
    ComplaintModel convertEntityToModel(Complaint complaintEntity);
}
