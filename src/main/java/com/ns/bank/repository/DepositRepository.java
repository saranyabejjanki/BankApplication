package com.ns.bank.repository;

import com.ns.bank.entity.Customer;
import com.ns.bank.entity.Deposit;
import com.ns.bank.model.DepositModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.deposit WHERE status_id = ?1")
    List<Deposit> getAllDepositsByStatusId(Long statusId);
    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.deposit WHERE customer_id=?1")
    List<Deposit> getDepositsByAccountNumber(Long accountNumber);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE bankapplication.deposit SET status_id=:statusId WHERE id=:depositId")
    int updateDepositStatus(@Param("statusId") Long statusId, @Param("depositId") Long depositId);

    @Query(nativeQuery = true,value = "SELECT COUNT(*) FROM bankapplication.deposit WHERE customer_id=?1")
    Integer getDepositsCountByAccountNumber(Long accountNumber);
}