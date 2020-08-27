package com.ns.bank.service;

import com.ns.bank.model.AddressModel;
import com.ns.bank.model.ComplaintModel;

import java.util.List;

public interface IComplaintService {

    List<ComplaintModel> fetchAllComplaints();
    Boolean checkIfComplaintExists(Long complaintId);
    ComplaintModel fetchComplaintById(Long complaintId);
    ComplaintModel  saveComplaint(ComplaintModel complaintModel);
    ComplaintModel updateComplaint(ComplaintModel complaintModel);
    Boolean deleteComplaintById(Long complaintId);
    List<ComplaintModel> fetchComplaintByStatusId(Long statusId);
    List<ComplaintModel> fetchComplaintByAccountNumber(Long account_no);
    ComplaintModel updateStatus(Long statusId,Long complaintId);
    Integer getComplaintCountByStatusId(Long statusId);
    Integer getComplaintCount();
}
