package com.ns.bank.mapper;

import com.ns.bank.entity.Address;
import com.ns.bank.entity.Branch;
import com.ns.bank.model.AddressModel;
import com.ns.bank.model.BranchModel;

public interface IBranchMapper {

   Branch convertModelToEntity(BranchModel branchModel);
   BranchModel convertEntityToModel(Branch branchEntity);
}
