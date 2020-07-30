package com.ns.bank.service;

import com.ns.bank.entity.User;
import com.ns.bank.model.*;


import java.util.List;

public interface IBranchService {
    List<BranchModel> fetchAllBranches();
    Boolean checkIfBranchExists(Long branchCode);
    BranchModel fetchBranchByCode(Long branchCode);
    BranchModel  saveBranch(BranchModel branchModel);
    BranchModel updateBranch(BranchModel branchModel);
    Boolean deleteBranchByBranchCode(Long branchCode);
    public List<UserModel> getAllUsersByBranchCode(Long branchCode);
    public List<CustomerModel> getAllCustomersByBranchCode(Long branchCode);
    public List<UserModel> getAllUsersByRowStatusId(Long rowStatusId);
}
