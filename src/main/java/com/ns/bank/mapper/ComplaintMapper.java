package com.ns.bank.mapper;

import com.ns.bank.entity.Complaint;
import com.ns.bank.model.ComplaintModel;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;
@Component
public class ComplaintMapper implements  IComplaintMapper {

    @Override
    public Complaint convertModelToEntity(ComplaintModel complainModel) {
        Complaint complaint = new Complaint();
        if (nonNull(complainModel)) {
            if (nonNull(complainModel.getId())) {
                complaint.setId(complainModel.getId());
            }
            complaint.setDescription(complainModel.getDescription());
            complaint.setRaisedDate(complainModel.getRaisedDate());
            complaint.setUpdatedDate(complainModel.getUpdatedDate());
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
        }
        return complaintModel;
    }
}
