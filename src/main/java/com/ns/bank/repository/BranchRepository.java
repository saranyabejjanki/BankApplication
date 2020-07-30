package com.ns.bank.repository;

import com.ns.bank.entity.Branch;
import com.ns.bank.entity.Customer;
import com.ns.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {

    public List<com.ns.bank.entity.User> getAllUsersByBranchCode(Long branchCode);
    public List<Customer> getAllCustomersByBranchCode(Long branchCode);
    //@Query("Select user from Branch  branch where branch.rowStatus.id=?1")
    public List<User> getAllUsersByRowStatusId(Long rowStatusId);
}