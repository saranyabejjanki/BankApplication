package com.ns.bank.service.impl;

import com.ns.bank.entity.Deposit;
import com.ns.bank.entity.Withdraw;
import com.ns.bank.model.DepositModel;
import com.ns.bank.model.WithdrawModel;
import com.ns.bank.repository.WithdrawRepository;
import com.ns.bank.service.IWithdrawService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WithdrawService implements IWithdrawService {
    @Autowired
    private WithdrawRepository withdrawRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<WithdrawModel> getAllWithdraws() {
        List<Withdraw> withdrawEntities=withdrawRepository.findAll();
        List<WithdrawModel> withdrawsModels=new ArrayList<>();
        withdrawEntities.forEach(withdraw-> withdrawsModels.add(modelMapper.map(withdraw, WithdrawModel.class)));
        return  withdrawsModels;
    }

    @Override
    public WithdrawModel getWithdrawById(Long withdrawId) {
        Optional<Withdraw> withdraw= withdrawRepository.findById(withdrawId);
        System.out.println("withdraw"+withdraw.get());
        WithdrawModel withdrawModel=new WithdrawModel();
        if(withdraw.isPresent()){
            withdrawModel=modelMapper.map(withdraw.get(),WithdrawModel.class);
        }
        return withdrawModel;
    }

    @Override
    public boolean checkWithdrawIdExists(Long withdrawId) {
        return withdrawRepository.existsById(withdrawId);
    }

    @Override
    public WithdrawModel createWithdraw(WithdrawModel withdrawModel) {
        Withdraw withdraw=modelMapper.map(withdrawModel,Withdraw.class);
        Withdraw  withdrawResponse=withdrawRepository.save(withdraw);
        WithdrawModel withdrawModel1=modelMapper.map(withdrawResponse,WithdrawModel.class);
        return withdrawModel1;
    }

    @Override
    public int updateWithdrawStatus(Long statusId, Long withdrawId) {
        return withdrawRepository.updateWithdrawStatus(statusId,withdrawId);
    }

    @Override
    public List<WithdrawModel> getAllWithdrawByStatusId(Long statusId) {
        List<Withdraw> withdrawEntities= withdrawRepository.getAllWithdrawsByStatusId(statusId);
        List<WithdrawModel> withdrawModels=new ArrayList<>();
        withdrawEntities.forEach(withdraw->  withdrawModels.add(modelMapper.map(withdraw, WithdrawModel.class)));
        return withdrawModels;
    }

    @Override
    public List<WithdrawModel> getWithdrawsByAccountNumber(Long accountNumber) {
        List<Withdraw> withdrawEntities=withdrawRepository.getWithdrawsByAccountNumber(accountNumber);
        List<WithdrawModel> withdrawsModels=new ArrayList<>();
        withdrawEntities.forEach(withdraw->  withdrawsModels.add(modelMapper.map(withdraw, WithdrawModel.class)));
        return withdrawsModels;
    }
}
