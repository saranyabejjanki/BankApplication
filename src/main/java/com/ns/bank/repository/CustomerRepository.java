package com.ns.bank.repository;

import com.ns.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.customer WHERE status_id = ?1")
    List<Customer> getAllCustomersByStatusId(Long statusId);
    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.customer WHERE branch_id = ?1")
    List<Customer> getAllCustomersByBranchId(Long branchId );
    @Query(nativeQuery = true,value ="SELECT * FROM bankapplication.customer WHERE account_type_id = ?1" )
    List<Customer> getAllCustomersByAccountTypeId(Long accountTypeId);
}