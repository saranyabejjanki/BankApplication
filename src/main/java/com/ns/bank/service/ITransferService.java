package com.ns.bank.service;
import com.ns.bank.model.DepositModel;
import com.ns.bank.model.TransferModel;
import java.util.List;

public interface ITransferService {
    List<TransferModel> getAllTransfers();
    TransferModel getTransferById(Long transferId);
    boolean checkTransferIdExists(Long transferId);
    TransferModel createTransfer(TransferModel transferModel);
    int updateTransferStatus(Long statusId,Long transferId);
    List<TransferModel> getAllTransferByStatusId(Long statusId);
    List<TransferModel> getTransfersByAccountNumber(Long accountNumber);
    Integer getTransfersCountByAccountNumber(Long accountNumber);
}
