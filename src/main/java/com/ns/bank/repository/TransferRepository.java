package com.ns.bank.repository;

import com.ns.bank.entity.Deposit;
import com.ns.bank.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.transfer WHERE status_id = ?1")
    List<Transfer> getAllTransfersByStatusId(Long statusId);
    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.transfer WHERE customer_account_no=?1")
    List<Transfer> getTransfersByAccountNumber(Long accountNumber);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE bankapplication.transfer SET status_id=:statusId WHERE id=:transferId")
    int updateTransferStatus(@Param("statusId") Long statusId, @Param("transferId") Long transferId);

}