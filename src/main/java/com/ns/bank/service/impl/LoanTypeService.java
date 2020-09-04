package com.ns.bank.service.impl;

import com.ns.bank.entity.LoanType;
import com.ns.bank.model.LoanTypeModel;
import com.ns.bank.repository.LoanRepository;
import com.ns.bank.repository.LoanTypeRepository;
import com.ns.bank.service.ILoanTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanTypeService implements ILoanTypeService {

    @Autowired
    private LoanTypeRepository loanTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LoanTypeModel> getAllLoans() {

        List<LoanType> loanTypes = loanTypeRepository.findAll();
        List<LoanTypeModel> loanTypeModels = new ArrayList<>();
        loanTypes.forEach(loanType -> {
            loanTypeModels.add(modelMapper.map(loanType, LoanTypeModel.class));
        });
        return loanTypeModels;
    }

    @Override
    public LoanTypeModel getLoanTypeByLoanId(Integer loanTypeId) {
        Optional<LoanType> loanType = loanTypeRepository.findById(loanTypeId);
        if(loanType.isPresent()){
            return modelMapper.map(loanType.get(),LoanTypeModel.class);
        }else
        return null;
    }
}
