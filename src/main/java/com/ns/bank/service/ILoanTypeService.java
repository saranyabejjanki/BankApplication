package com.ns.bank.service;

import com.ns.bank.model.LoanTypeModel;

import java.util.List;

public interface ILoanTypeService {
    List<LoanTypeModel> getAllLoans();
    LoanTypeModel getLoanTypeByLoanId(Integer loanTypeId);
}
