package com.ns.bank.repository;

import com.ns.bank.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query(nativeQuery = true,value = "SELECT count(*) FROM bankapplication.loan as loans where loans.custome_id=?1")
    int existByCustomer(Long customerId);

    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.loan as loans where loans.custome_id=?1")
    List<Loan> findAllByCustomer(Long customerId);

    @Modifying
    @Query(nativeQuery = true,value = "UPDATE loan SET status_id = ?1 where id=?2")
    int updateLoanStatus(Long statusId, Long loanId);
}