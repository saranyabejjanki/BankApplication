package com.ns.bank.service;

import com.ns.bank.entity.Loan;
import com.ns.bank.model.LoanModel;

import java.util.List;

public interface ILoanService {
    List<LoanModel> getAllLoans();

    List<LoanModel> getAllLoansByCustomerId(Long customerId);

    boolean existByCustomerId(Long customerId);

    LoanModel getLoanByLoanId(Long loanId);

    boolean existByLoanId(Long loanId);

    LoanModel createLoan(LoanModel loanModel);

    LoanModel updateLoand(LoanModel loanModel);

    int updateLoanStatus(Long statusId, Long loanId);
}
