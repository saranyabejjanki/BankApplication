package com.ns.bank.service.impl;

import com.ns.bank.entity.Loan;
import com.ns.bank.model.LoanModel;
import com.ns.bank.repository.LoanRepository;
import com.ns.bank.service.ILoanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService implements ILoanService {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<LoanModel> getAllLoans() {
        List<LoanModel> loanModels = new ArrayList<>();
        List<Loan> loans = loanRepository.findAll();
        loans.forEach(loan -> loanModels.add(modelMapper.map(loan,LoanModel.class)));
        return loanModels;
    }



    @Override
    public List<LoanModel> getAllLoansByCustomerId(Long customerId) {
        List<LoanModel> loanModels = new ArrayList<>();
        List<Loan> loans = loanRepository.findAllByCustomer(customerId);
        loans.forEach(loan -> loanModels.add(modelMapper.map(loan,LoanModel.class)));
        return loanModels;
    }

    @Override
    public boolean existByCustomerId(Long customerId) {
        int count = loanRepository.existByCustomer(customerId);
        return count>0 ? true : false;
    }

    @Override
    public LoanModel getLoanByLoanId(Long loanId) {
        Optional<Loan> loan = loanRepository.findById(loanId);
        if(loan.isPresent()){
            LoanModel loanModel = modelMapper.map(loan.get(),LoanModel.class);
            return loanModel;
        }else
          return null;
    }

    @Override
    public boolean existByLoanId(Long loanId) {
        return loanRepository.existsById(loanId);
    }

    @Override
    public LoanModel createLoan(LoanModel loanModel) {
        Loan loan = modelMapper.map(loanModel,Loan.class);
       Loan loan1= loanRepository.save(loan);
        loanModel = modelMapper.map(loan1,LoanModel.class);
        return loanModel;
    }

    @Override
    public LoanModel updateLoand(LoanModel loanModel) {
        Loan loan = modelMapper.map(loanModel,Loan.class);
        Loan loan1 = loanRepository.save(loan);
        return modelMapper.map(loan1,LoanModel.class);
    }

    @Override
    public int updateLoanStatus(Long statusId, Long loanId) {
        return loanRepository.updateLoanStatus(statusId,loanId);
    }


}
