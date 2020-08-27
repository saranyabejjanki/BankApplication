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

    @Query(nativeQuery = true, value = "Select users from Branch branch where branch.branchCode=?1")
    public List<com.ns.bank.entity.User> getAllUsersByBranchCode(Long branchCode);

    @Query(nativeQuery = true, value = "Select customers from Branch branch where branch.branchCode=?1")
    public List<Customer> getAllCustomersByBranchCode(Long branchCode);
    //@Query("Select user from Branch  branch where branch.rowStatus.id=?1")

    @Query(nativeQuery = true, value = "select * from bankapplication.users where row_status_id=?1")
    public List<User> getAllUsersByRowStatusId(Long rowStatusId);

    @Query(nativeQuery = true, value = "select count(*) from bankapplication.branch ")
    Integer getAllBranchesCount();

    @Query(nativeQuery = true,value = "SELECT branch_id, sum(balance), bankapplication.branch.name from " +
            "bankapplication.branch RIGHT JOIN bankapplication.customer ON bankapplication.customer.branch_id = " +
            "bankapplication.branch.branch_code GROUP BY bankapplication.customer.branch_id")
    List<Object> getAllBranchesBalance();
}