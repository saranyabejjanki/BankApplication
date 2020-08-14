package com.ns.bank.service;
import com.ns.bank.model.WithdrawModel;
import java.util.List;

public interface IWithdrawService {
    List<WithdrawModel> getAllWithdraws();
    WithdrawModel getWithdrawById(Long withdrawId);
    boolean checkWithdrawIdExists(Long  withdrawId);
    WithdrawModel createWithdraw(WithdrawModel drawModel);
    int updateWithdrawStatus(Long statusId,Long withdrawId);
    List<WithdrawModel> getAllWithdrawByStatusId(Long statusId);
    List<WithdrawModel> getWithdrawsByAccountNumber(Long accountNumber);
}
