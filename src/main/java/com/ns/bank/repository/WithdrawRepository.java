package com.ns.bank.repository;

import com.ns.bank.entity.Deposit;
import com.ns.bank.entity.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WithdrawRepository extends JpaRepository<Withdraw, Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.withdraw  WHERE status_id = ?1")
    List<Withdraw> getAllWithdrawsByStatusId(Long statusId);
    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.withdraw WHERE customer_id=?1")
    List<Withdraw> getWithdrawsByAccountNumber(Long accountNumber);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE bankapplication.withdraw SET status_id=:statusId WHERE id=:withdrawId")
    int updateWithdrawStatus(@Param("statusId") Long statusId, @Param("withdrawId") Long withdrawId);

}