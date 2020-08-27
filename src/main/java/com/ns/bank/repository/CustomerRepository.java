package com.ns.bank.repository;

import com.ns.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.customer WHERE status_id = ?1")
    List<Customer> getAllCustomersByStatusId(Long statusId);
    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.customer WHERE branch_id = ?1")
    List<Customer> getAllCustomersByBranchId(Long branchId );
    @Query(nativeQuery = true,value ="SELECT * FROM bankapplication.customer WHERE account_type_id = ?1" )
    List<Customer> getAllCustomersByAccountTypeId(Long accountTypeId);
    Optional<Customer> findByEmail(String email);
    Optional<Customer>findByEmailAndPassword(String email,String password);
    @Query(nativeQuery = true,value ="SELECT balance FROM bankapplication.customer WHERE account_no =?1" )
    Double findBalanceByAccountNo(Long accountNumber);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value ="UPDATE bankapplication.customer SET balance=balance+?1 WHERE account_no =?2")
    Integer updateAccountBalanceByAccountNumber(Double amount,Long accountNumber);

    @Query(nativeQuery = true,value =" SELECT COUNT(*) FROM bankapplication.customer WHERE branch_id =?1")
    Integer getAllCustomersCountByBranchId(Long branchCode);
    @Query(nativeQuery = true,value ="SELECT COUNT(*) FROM bankapplication.customer")
    Integer getAllCustomersCount();

    @Query(nativeQuery = true,value = "SELECT SUM(balance) From bankapplication.customer")
    Integer getBankBalance();
}