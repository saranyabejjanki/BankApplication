package com.ns.bank.service.impl;

import com.ns.bank.entity.Address;
import com.ns.bank.entity.Complaint;
import com.ns.bank.mapper.ComplaintMapper;
import com.ns.bank.model.AddressModel;
import com.ns.bank.model.ComplaintModel;
import com.ns.bank.repository.ComplaintRepository;
import com.ns.bank.service.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintService implements IComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private ComplaintMapper complaintMapper;
    @Override
    public List<ComplaintModel> fetchAllComplaints() {

        List<Complaint> complaintEntities= complaintRepository.findAll();
        List<ComplaintModel> complaintModels=new ArrayList<>();
        complaintEntities.forEach(complaint -> complaintModels.add(complaintMapper.convertEntityToModel((complaint))));
        return complaintModels;
    }

    @Override
    public Boolean checkIfComplaintExists(Long complaintId) {
        return complaintRepository.existsById(complaintId);
    }

    @Override
    public ComplaintModel fetchComplaintById(Long complaintId) {
        return null;
    }

    @Override
    public ComplaintModel saveComplaint(ComplaintModel complaintModel) {
        return null;
    }

    @Override
    public ComplaintModel updateComplaint(ComplaintModel complaintModel) {
        return null;
    }

    @Override
    public Boolean deleteComplaintById(Long complaintId) {
        return null;
    }
}
