package com.ns.bank.mapper;

import com.ns.bank.entity.AccountType;
import com.ns.bank.model.AccountTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AccountTypeMapper {

    @Autowired
    private EligibilityMapper eligibilityMapper;

    public AccountType convertModelToEntity(AccountTypeModel accountTypeModel){
        AccountType accountType = new AccountType();
        if(Objects.nonNull(accountTypeModel)){
            accountType.setName(accountTypeModel.getName());
            accountType.setInterest(accountTypeModel.getInterest());
            accountType.setMinBalance(accountTypeModel.getMinBalance());
            accountType.setTransactionLimit(accountTypeModel.getTransactionLimit());
            accountType.setWithdrawLimit(accountTypeModel.getWithdrawLimit());

            if(Objects.nonNull(accountTypeModel.getEligibilityModel()))
                accountType.setEligibilityId(eligibilityMapper.convertModelToEntity(accountTypeModel.getEligibilityModel()));

            if(Objects.nonNull(accountTypeModel.getId()))
                accountType.setId(accountTypeModel.getId());
        }

        return accountType;
    }

    public AccountTypeModel convertEntityToModel(AccountType accountType){
        AccountTypeModel accountTypeModel = new AccountTypeModel();
        if(Objects.nonNull(accountType)){
            if(Objects.nonNull(accountType.getId()))
                accountTypeModel.setId(accountType.getId());
            accountTypeModel.setName(accountType.getName());
            accountTypeModel.setMinBalance(accountType.getMinBalance());
            accountTypeModel.setInterest(accountType.getInterest());
            accountTypeModel.setWithdrawLimit(accountType.getWithdrawLimit());
            accountTypeModel.setTransactionLimit(accountType.getTransactionLimit());
            if(Objects.nonNull(accountType.getEligibilityId()))
                accountTypeModel.setEligibilityModel(eligibilityMapper.convertEntityToModel(accountType.getEligibilityId()));

        }
           return accountTypeModel;
    }
}
