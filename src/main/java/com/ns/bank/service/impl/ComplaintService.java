package com.ns.bank.service.impl;

import com.ns.bank.entity.Complaint;
import com.ns.bank.mapper.ComplaintMapper;
import com.ns.bank.model.ComplaintModel;
import com.ns.bank.repository.ComplaintRepository;
import com.ns.bank.service.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

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
        Optional<Complaint> complaintEntity=complaintRepository.findById(complaintId);
        ComplaintModel complaintModel=new ComplaintModel();
        if(nonNull(complaintEntity))
            complaintModel=complaintMapper.convertEntityToModel(complaintEntity.get());
        return complaintModel;
    }

    @Override
    public ComplaintModel saveComplaint(ComplaintModel complaintModel) {
        ComplaintModel complaint= new ComplaintModel();
        if (nonNull(complaintModel )) {
            Complaint complaintEntity = complaintMapper.convertModelToEntity(complaintModel);
            Complaint responseComplaintEntity = complaintRepository.save(complaintEntity );
            complaint = complaintMapper.convertEntityToModel(responseComplaintEntity);
        }
        return complaint;
    }

    @Override
    public ComplaintModel updateComplaint(ComplaintModel complaintModel) {
        ComplaintModel complaint = new ComplaintModel();
        ComplaintModel updatedComplaint = new ComplaintModel();
        if (nonNull(complaintModel)) {
            Optional<Complaint> complaint1 = complaintRepository.findById(complaintModel.getId());
            complaint1.get().setDescription(complaintModel.getDescription());
            complaint1.get().setRaisedDate(complaintModel.getRaisedDate());
            complaint1.get().setUpdatedDate(complaintModel.getUpdatedDate());
            complaint=complaintMapper.convertEntityToModel(complaint1.get());
        }
        return  complaint;
    }
    @Override
    public Boolean deleteComplaintById(Long complaintId) {
        if( complaintRepository.existsById(complaintId)){
            complaintRepository.deleteById(complaintId);
            return  true;
        }
        return false;
    }

    @Override
    public List<ComplaintModel> fetchComplaintByStatusId(Long statusId) {
       List<Complaint> complaints= complaintRepository.fetchComplaintByStatusId(statusId);
        List<ComplaintModel> complaintModels=new ArrayList<>();
        if(nonNull(complaints.size()>0)){
            complaints.forEach(complaint->complaintModels.add(complaintMapper.convertEntityToModel(complaint)));
        }
        return  complaintModels;
    }

    @Override
    public List<ComplaintModel> fetchComplaintByAccountNumber(Long accountNumber) {
       List<Complaint> complaints= complaintRepository.fetchComplaintByAccountNumber(accountNumber);
        List<ComplaintModel> complaintModels=new ArrayList<>();
        if(complaints.size()>0) {
            complaints.forEach(complaint -> complaintModels.add(complaintMapper.convertEntityToModel((complaint))));
        }
        return  complaintModels;
    }

    @Override
    public ComplaintModel updateStatus(Long statusId,Long complaintId) {
        Complaint complaint =complaintRepository.updateStatus(statusId,complaintId);
        ComplaintModel complaintModel=new ComplaintModel();
        if(nonNull(complaint))
            complaintModel=complaintMapper.convertEntityToModel(complaint);
        return  complaintModel;
    }

    @Override
    public Integer getComplaintCountByStatusId(Long statusId) {
        return  complaintRepository.getCompalintCountByStatus(statusId);
    }

    @Override
    public Integer getComplaintCount() {
        return complaintRepository.getComplaintsCount();
    }

    @Override
    public List<ComplaintModel> fetchComplaintByStatusIdAndBranchId(Long statusId, Long branchId) {
        return null;
    }

    @Override
    public Integer fetchComplaintsCountByStatusIdAndBranchId(Long statusId, Long branchId) {
        return complaintRepository.getCompalintCountByStatusAndBranchId(statusId,branchId);
    }
}
