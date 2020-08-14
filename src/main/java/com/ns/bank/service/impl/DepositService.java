package com.ns.bank.service.impl;
import com.ns.bank.entity.Customer;
import com.ns.bank.entity.Deposit;
import com.ns.bank.model.DepositModel;
import com.ns.bank.repository.DepositRepository;
import com.ns.bank.service.IDepositService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepositService implements IDepositService {

    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DepositModel> getAllDeposits() {
        List<Deposit> depositEntities=depositRepository.findAll();
        List<DepositModel> depositsModels=new ArrayList<>();
        depositEntities.forEach(deposit->  depositsModels.add(modelMapper.map(deposit, DepositModel.class)));
        return  depositsModels;
    }

    @Override
    public DepositModel getDepositById(Long depositId) {
        Optional<Deposit> deposit= depositRepository.findById(depositId);
        DepositModel depositModel=new DepositModel();
        if(deposit.isPresent()){
           depositModel=modelMapper.map(deposit.get(),DepositModel.class);
        }
        return depositModel;

    }

    @Override
    public boolean checkDepositIdExists(Long depositId) {
        return depositRepository.existsById(depositId);
    }

    @Override
    public DepositModel createDeposit(DepositModel depositModel) {
        Deposit deposit=modelMapper.map(depositModel,Deposit.class);
        Deposit  depositResponse=depositRepository.save(deposit);
        DepositModel depositModel1=modelMapper.map(depositResponse,DepositModel.class);
        return depositModel1;
    }

    @Override
    public int updateDepositStatus(Long statusId,Long depositId) {
        return  depositRepository.updateDepositStatus(statusId,depositId);
    }

    @Override
    public List<DepositModel> getAllDepositByStatusId(Long statusId) {
        List<Deposit> depositEntities= depositRepository.getAllDepositsByStatusId(statusId);
        List<DepositModel> depositsModels=new ArrayList<>();
        depositEntities.forEach(deposit->  depositsModels.add(modelMapper.map(deposit, DepositModel.class)));
        return depositsModels;
    }

    @Override
    public List<DepositModel> getDepositsByAccountNumber(Long accountNumber) {
        List<Deposit> depositEntities=depositRepository.getDepositsByAccountNumber(accountNumber);
        List<DepositModel> depositsModels=new ArrayList<>();
        depositEntities.forEach(deposit->  depositsModels.add(modelMapper.map(deposit, DepositModel.class)));
        return depositsModels;
    }
}
