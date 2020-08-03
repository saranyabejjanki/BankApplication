package com.ns.bank.controller;

import com.ns.bank.entity.Branch;
import com.ns.bank.entity.User;
import com.ns.bank.model.AddressModel;
import com.ns.bank.model.BranchModel;
import com.ns.bank.model.CustomerModel;
import com.ns.bank.model.UserModel;
import com.ns.bank.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api/branches")
public class BranchController {
    @Autowired
    private IBranchService branchService;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<BranchModel>> fetchAllBranches() {
        List<BranchModel> branchesList = branchService.fetchAllBranches();
            return new ResponseEntity<List<BranchModel>>(branchesList, branchesList.size()!=0 ? HttpStatus.OK: HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{branch-code}")
    public ResponseEntity<BranchModel> fetchBranchByCode(@PathVariable("branch-code") Long branchCode) throws Exception {
        if (branchService.checkIfBranchExists(branchCode)) {
            BranchModel branchModel = branchService.fetchBranchByCode(branchCode);
            return new ResponseEntity<BranchModel>(branchModel, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping(path = "/{branch-code}/customers")
    public ResponseEntity<List<CustomerModel>> fetchAllCustomersByCode(@PathVariable("branch-code") Long branchCode) throws Exception {
        List<CustomerModel>  customers=new ArrayList<>();
        if (branchService.checkIfBranchExists(branchCode)) {
            customers= branchService.getAllCustomersByBranchCode(branchCode);
        }
        return new ResponseEntity<List<CustomerModel>>(customers, customers.size()>0?HttpStatus.OK:HttpStatus.NO_CONTENT);
    }


    @PostMapping(consumes ={"application/json"})
    public ResponseEntity<?> createBranch(@RequestBody BranchModel branchModel) throws Exception {
        HttpStatus status;
        BranchModel branch = branchService.saveBranch(branchModel);
        System.out.println(branch);
        status = nonNull(branch) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(branch,status);
    }

    @PutMapping(path="/{branch-code}")
    public ResponseEntity<?> updateUser(@PathVariable("branch-code") Long branchCode,@RequestBody BranchModel branchModel) throws Exception{
        HttpStatus status;
        if(branchService.checkIfBranchExists(branchCode)){
           BranchModel branch= branchService.updateBranch(branchModel);
            status = nonNull(branch) ? HttpStatus.OK: HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(status);
        }
        else{
            //  throw new UserNotFoundException("User id '" + userId + "' does not exist");
            return null;
        }
    }

//
//    @DeleteMapping(path="/{branch-code}")
//    public ResponseEntity<?> deleteBranchByCode(@PathVariable("branch-code") Long branchCode) throws Exception {
//        HttpStatus status;
//        if (branchService.checkIfBranchExists(branchCode)) {
//            Boolean value = branchService.deleteBranchByBranchCode(branchCode);
//            status = value == true ? HttpStatus.NO_CONTENT : HttpStatus.NOT_ACCEPTABLE;
//            return new ResponseEntity<>(value, status);
//        } else {
//            //throw new AddressNotFoundException("User id '" + userId + "' does not exist");
//            return null;
//        }
//
//    }


}
