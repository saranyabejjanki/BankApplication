package com.ns.bank.service;

import com.ns.bank.entity.Branch;
import com.ns.bank.entity.Customer;
import com.ns.bank.entity.RowStatus;
import com.ns.bank.model.AddressModel;
import com.ns.bank.model.BranchModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IBranchService {
    List<Branch> fetchAllBranches();
    Boolean checkIfBranchExists(Long branchCode);
    Optional<Branch> fetchBranchByCode(Long branchCode);
    Branch  saveBranch(Branch branchModel);
    Branch updateBranch(Branch branchModel);
    Boolean deleteBranchByBranchCode(Long branchCode);
    public List<User> getAllUsersByBranchCode(Long branchCode);
    public List<Customer> getAllCustomersByBranchCode(Long branchCode);
    public List<RowStatus> getAllUsersByRowStatusId(Long rowStatusId);
}
