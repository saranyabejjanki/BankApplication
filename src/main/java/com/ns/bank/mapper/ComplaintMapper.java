package com.ns.bank.mapper;

import com.ns.bank.entity.Complaint;
import com.ns.bank.model.ComplaintModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;
@Component
public class ComplaintMapper implements  IComplaintMapper {
    @Autowired
    private StatusMapper  statusMapper;

    @Autowired
    private  CustomerMapper customerMapper;


    @Override
    public Complaint convertModelToEntity(ComplaintModel complaintModel) {
        Complaint complaint = new Complaint();
        if (nonNull(complaintModel)) {
            if (nonNull(complaintModel.getId())) {
                complaint.setId(complaintModel.getId());
            }
            complaint.setDescription(complaintModel.getDescription());
            complaint.setRaisedDate(complaintModel.getRaisedDate());
            complaint.setUpdatedDate(complaintModel.getUpdatedDate());
            complaint.setStatus(statusMapper.convertModelToEntity(complaintModel.getStatusModel()));
            complaint.setCustomer(customerMapper.convertModelToEntity(complaintModel.getCustomerModel()));
        }
        return  complaint;

    }
    @Override
    public ComplaintModel convertEntityToModel(Complaint complaintEntity) {
        ComplaintModel complaintModel = new ComplaintModel();
        if (nonNull(complaintEntity)) {
            if (nonNull(complaintEntity.getId())) {
                complaintModel.setId(complaintEntity.getId());
            }
            complaintModel.setDescription(complaintEntity.getDescription());
            complaintModel.setRaisedDate(complaintEntity.getRaisedDate());
            complaintModel.setUpdatedDate(complaintEntity.getUpdatedDate());
            complaintModel.setStatusModel(statusMapper.convertEntityToModel(complaintEntity.getStatus()));
            complaintModel.setCustomerModel(customerMapper.convertEntityToModel(complaintEntity.getCustomer()));
        }
        return complaintModel;
    }
}
