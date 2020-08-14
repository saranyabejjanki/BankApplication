package com.ns.bank.service.impl;

import com.ns.bank.entity.Deposit;
import com.ns.bank.entity.Transfer;
import com.ns.bank.model.DepositModel;
import com.ns.bank.model.TransferModel;
import com.ns.bank.repository.TransferRepository;
import com.ns.bank.service.ITransferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransferService implements ITransferService {

    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TransferModel> getAllTransfers() {
        List<Transfer> transferEntities=transferRepository.findAll();
        List<TransferModel> transfersModels=new ArrayList<>();
        transferEntities.forEach(transfer-> transfersModels.add(modelMapper.map(transfer, TransferModel.class)));
        return  transfersModels;
    }

    @Override
    public TransferModel getTransferById(Long transferId) {
        Optional<Transfer> transfer= transferRepository.findById(transferId);
      //  System.out.println("Transfer"+transfer.get());
        TransferModel transferModel=new TransferModel();
        if(transfer.isPresent()){
            transferModel=modelMapper.map(transfer.get(),TransferModel.class);
        }
        return transferModel;
    }

    @Override
    public boolean checkTransferIdExists(Long transferId) {
        return transferRepository.existsById(transferId);
    }

    @Override
    public TransferModel createTransfer(TransferModel transferModel) {
        Transfer transfer=modelMapper.map(transferModel,Transfer.class);
        Transfer transferResponse=transferRepository.save(transfer);
        TransferModel transferModel1=modelMapper.map(transferResponse,TransferModel.class);
        return transferModel1;
    }

    @Override
    public int updateTransferStatus(Long statusId, Long transferId) {
        return transferRepository.updateTransferStatus(statusId,transferId);
    }

    @Override
    public List<TransferModel> getAllTransferByStatusId(Long statusId) {
        List<Transfer>  transferEntities= transferRepository.getAllTransfersByStatusId(statusId);
        List<TransferModel> transfersModels=new ArrayList<>();
        transferEntities.forEach(transfer->  transfersModels.add(modelMapper.map(transfer, TransferModel.class)));
        return transfersModels;
    }

    @Override
    public List<TransferModel> getTransfersByAccountNumber(Long accountNumber) {
        List<Transfer> transferEntities=transferRepository.getTransfersByAccountNumber(accountNumber);
        List<TransferModel> transfersModels=new ArrayList<>();
        transferEntities.forEach(transfer->  transfersModels.add(modelMapper.map(transfer, TransferModel.class)));
        return transfersModels;
    }
}
