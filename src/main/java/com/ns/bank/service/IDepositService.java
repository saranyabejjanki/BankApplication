package com.ns.bank.service;


import com.ns.bank.entity.Deposit;
import com.ns.bank.model.CustomerModel;
import com.ns.bank.model.DepositModel;

import java.util.List;

public interface IDepositService {
    List<DepositModel> getAllDeposits();
    DepositModel getDepositById(Long depositId);
    boolean checkDepositIdExists(Long depositId);
    DepositModel createDeposit(DepositModel depositModel);
    int updateDepositStatus(Long statusId,Long depositId);
    List<DepositModel> getAllDepositByStatusId(Long statusId);
    List<DepositModel> getDepositsByAccountNumber(Long accountNumber);
    Integer getDepositsCountByAccountNumber(Long accountNumber);
}
