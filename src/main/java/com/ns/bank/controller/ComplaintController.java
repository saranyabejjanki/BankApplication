package com.ns.bank.controller;

import com.ns.bank.entity.Complaint;
import com.ns.bank.mapper.IComplaintMapper;
import com.ns.bank.model.AddressModel;
import com.ns.bank.model.ComplaintModel;
import com.ns.bank.service.IAddressService;
import com.ns.bank.service.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private IComplaintService complaintService;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<ComplaintModel>> fetchAllComplaints() {
        List<ComplaintModel> complaintList = complaintService.fetchAllComplaints();
        return new ResponseEntity<>(complaintList, complaintList.size()!=0 ? HttpStatus.OK: HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{complaint-id}")
    public ResponseEntity<?> fetchComplaintById(@PathVariable("complaint-id") Long complaintId) throws Exception {
        if (complaintService.checkIfComplaintExists(complaintId)) {
          ComplaintModel complaintModel = complaintService.fetchComplaintById(complaintId);
            return new ResponseEntity<>(complaintModel, HttpStatus.OK);
        }   else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping(path="/count/{status-id}")
    public ResponseEntity<?> getComplaintCountByStatusId(@PathVariable("status-id") Long statusId){
         Integer count=complaintService.getComplaintCountByStatusId(statusId);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    @GetMapping(path="/count")
    public ResponseEntity<?> getComplaintCount(){
        Integer count=complaintService.getComplaintCount();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }



    @GetMapping(path = "/customers/{account-number}")
    public ResponseEntity<?> fetchComplaintByAccountNumber(/*@PathVariable("complaint-id") Long complaintId*/@PathVariable("account-number") Long accountNumber) throws Exception {
       // if (complaintService.checkIfComplaintExists(complaintId)) {
            List<ComplaintModel> complaintModelList = complaintService.fetchComplaintByAccountNumber(accountNumber);
            return new ResponseEntity<>(complaintModelList, HttpStatus.OK);
        //}   else {
           // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //}
    }




    @GetMapping(path = "/statuses/{status-id}")
    public ResponseEntity<?> fetchComplaintByStatusId(@PathVariable("status-id") Long statusId) throws Exception {

            List<ComplaintModel> complaintModels = complaintService.fetchComplaintByStatusId(statusId);
            return new ResponseEntity<>(complaintModels, HttpStatus.OK);
    }

    @GetMapping(path = "/statuses/{status-id}/branches/{branch-id}")
    public ResponseEntity<?> fetchComplaintsByStatusIdAndBranchId(@PathVariable("status-id") Long statusId,
                                                                 @PathVariable("branch-id") Long branchId) throws Exception {

        List<ComplaintModel> complaintModels = complaintService.fetchComplaintByStatusIdAndBranchId(statusId,branchId);
        return new ResponseEntity<>(complaintModels, HttpStatus.OK);
    }

    @GetMapping(path = "/count/statuses/{status-id}/branches/{branch-id}")
    public ResponseEntity<?> fetchComplaintsCountByStatusIdAndBranchId(@PathVariable("status-id") Long statusId,
                                                                  @PathVariable("branch-id") Long branchId) throws Exception {

        Integer count = complaintService.fetchComplaintsCountByStatusIdAndBranchId(statusId,branchId);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> createComplaint(@RequestBody ComplaintModel complaintModel) throws Exception {
        HttpStatus status;
        ComplaintModel complaint = complaintService.saveComplaint(complaintModel);
        System.out.println(complaint);
        status = Objects.nonNull(complaint) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(complaint,status);
    }

    @PutMapping(path="/{complaint-id}")
    public ResponseEntity<?> updateComplaint(@PathVariable("complaint-id") Long complaintId,@RequestBody ComplaintModel complaintModel) throws Exception{
        HttpStatus status;
       if(complaintService.checkIfComplaintExists(complaintId)){
            ComplaintModel complaint= complaintService.updateComplaint(complaintModel);
            status = Objects.nonNull(complaint) ? HttpStatus.OK: HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(status);
        }
        else{
            //  throw new UserNotFoundException("User id '" + userId + "' does not exist");
            return null;
        }
    }
  @PutMapping(path="{complaint-id}/statuses/{status-id}")
    public ResponseEntity<?> updateComplaintByStatusId(@PathVariable("complaint-id") Long complaintId,@PathVariable("status-id") Long statusId,@RequestBody ComplaintModel complaintModel) throws Exception{
        HttpStatus status;
       if(complaintService.checkIfComplaintExists(complaintId)){
            ComplaintModel complaint= complaintService.updateComplaint(complaintModel);
            status = Objects.nonNull(complaint) ? HttpStatus.OK: HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(status);
        }
        else{
            //  throw new UserNotFoundException("User id '" + userId + "' does not exist");
            return null;
        }
    }

    @DeleteMapping(path="/{complaint-id}")
    public ResponseEntity<?> deleteComplaintById(@PathVariable("complaint-id") Long complaintId) throws Exception {
        HttpStatus status;
        if (complaintService.checkIfComplaintExists(complaintId)) {
            Boolean value = complaintService.deleteComplaintById(complaintId);
            status = value == true ? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE;
            return new ResponseEntity<>(value, status);
        } else {
            //throw new AddressNotFoundException("User id '" + userId + "' does not exist");
            return null;
        }
    }
}