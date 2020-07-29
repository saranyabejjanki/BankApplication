package com.ns.bank.service.impl;

import com.ns.bank.entity.Branch;
import com.ns.bank.entity.Customer;
import com.ns.bank.entity.RowStatus;
import com.ns.bank.model.BranchModel;
import com.ns.bank.repository.AddressRepository;
import com.ns.bank.repository.BranchRepository;
import com.ns.bank.service.IBranchService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService implements IBranchService {


    @Autowired
    private BranchRepository branchRepository;


    @Override
    public List<Branch> fetchAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Boolean checkIfBranchExists(Long branchCode) {
        return branchRepository.existsById(branchCode);
    }

    @Override
    public Optional<Branch> fetchBranchByCode(Long branchCode) {
        return branchRepository.findById(branchCode);
    }

    @Override
    public Branch saveBranch(Branch branchModel) {
        return branchRepository.save(branchModel);
    }

    @Override
    public Branch updateBranch(Branch branchModel) {
        return branchRepository.save(branchModel);
    }

    @Override
    public Boolean deleteBranchByBranchCode(Long branchCode) {
        if( branchRepository.existsById(branchCode)){
            branchRepository.deleteById(branchCode);
            return  true;
        }
        return false;
    }


    @Override
    public List<User> getAllUsersByBranchCode(Long branchCode) {
        return branchRepository.getAllUsersByBranchCode(branchCode);
    }

    @Override
    public List<Customer> getAllCustomersByBranchCode(Long branchCode) {
        return branchRepository.getAllCustomersByBranchCode(branchCode);
    }

    @Override
    public List<RowStatus> getAllUsersByRowStatusId(Long rowStatusId) {
        return branchRepository.getAllUsersByRowStatusId(rowStatusId);
    }
}
