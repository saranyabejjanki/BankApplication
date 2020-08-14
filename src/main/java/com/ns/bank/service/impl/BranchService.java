package com.ns.bank.service.impl;

import com.ns.bank.entity.Customer;
import com.ns.bank.entity.User;
import com.ns.bank.entity.Branch;
import com.ns.bank.mapper.*;
import com.ns.bank.model.*;
import com.ns.bank.repository.BranchRepository;
import com.ns.bank.service.IBranchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
@Service
public class BranchService implements IBranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BranchMapper branchMapper;
    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private RowStatusMapper rowStatusMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<BranchModel> fetchAllBranches() {
        List<Branch> branchEntities=branchRepository.findAll();
        List<BranchModel> branchModels=new ArrayList<>();
        branchEntities.forEach(branch-> branchModels.add(branchMapper.convertEntityToModel((branch))));
        return branchModels;
    }

    @Override
    public Boolean checkIfBranchExists(Long branchCode) {
        return branchRepository.existsById(branchCode);
    }

    @Override
    public BranchModel fetchBranchByCode(Long branchCode) {
        Optional<Branch> branchEntity=branchRepository.findById(branchCode);
        BranchModel branchModel=new BranchModel();
        if(Objects.nonNull(branchEntity))
          //  System.out.println("Date"+branchEntity.get().getCreatedDate());
            branchModel=branchMapper.convertEntityToModel(branchEntity.get());

        return branchModel;
    }

    @Override
    public BranchModel saveBranch(BranchModel branchModel) {
        BranchModel branch = new BranchModel();
        if (Objects.nonNull(branchModel)) {
            Branch branchEntity = branchMapper.convertModelToEntity(branchModel);
            Branch responseBranchEntity = branchRepository.save(branchEntity);
            branch = branchMapper.convertEntityToModel(responseBranchEntity);

        }
        return branch;
    }

        @Override
       public  BranchModel updateBranch(BranchModel branchModel){
            BranchModel branch = new BranchModel();
            BranchModel updatedBranch = new BranchModel();
            if (Objects.nonNull(branchModel)) {
                Optional<Branch> branch1 = branchRepository.findById(branchModel.getBranchCode());
                branch1.get().setName(branchModel.getName());
                branch1.get().setPhoneNo(branchModel.getPhoneNo());
                branch1.get().setAddress(addressMapper.convertModelToEntity(branchModel.getAddressModel()));
                branch1.get().setCreatedDate(branchModel.getCreatedDate());
                branch1.get().setRowStatus(rowStatusMapper.convertModelToEntity(branchModel.getRowStatusModel()));
             /*   if (nonNull(branchModel.getCustomerModels())) {
                    Set<Customer> customers = branchModel.getCustomerModels().stream().map(customer -> {
                        Customer customerEntity = customerMapper.convertModelToEntity(customer);
                        return customerEntity;
                    }).collect(Collectors.toSet());
                    branch1.get().setCustomers(customers);
                }
                if (nonNull(branchModel.getUserModels())) {
                    Set<User> users = branchModel.getUserModels().stream().map(user -> {
                        User userEntity = userMapper.convertModelToEntity(user);
                        return userEntity;
                    }).collect(Collectors.toSet());
                    branch1.get().setUsers(users);
                }
        */
                branch = branchMapper.convertEntityToModel(branchRepository.save(branch1.get()));

            }
            return branch;
        }



    @Override
    public Boolean deleteBranchByBranchCode(Long branchCode) {
        if( branchRepository.existsById(branchCode)){
            branchRepository.deleteById(branchCode);
            return  true;
        }
        return false;
    }


    @Override
    public List<UserModel> getAllUsersByBranchCode(Long branchCode) {
        List<User> userEntities=branchRepository.getAllUsersByBranchCode(branchCode);
        List<UserModel> userModels=new ArrayList<>();
        userEntities.forEach(user->userModels.add(userMapper.convertEntityToModel((user))));
        return userModels;

    }

    @Override
    public List<CustomerModel> getAllCustomersByBranchCode(Long branchCode) {
        List<Customer> customersEntities=branchRepository.getAllCustomersByBranchCode(branchCode);
        List<CustomerModel>  customerModels=new ArrayList<>();
        customersEntities.forEach(customer->customerModels.add(customerMapper.convertEntityToModel((customer))));
        return customerModels;
    }

    @Override
    public List<UserModel> getAllUsersByRowStatusId(Long rowStatusId) {
        List<User> userEntities=branchRepository.getAllUsersByRowStatusId(rowStatusId);
        List<UserModel> userModels=new ArrayList<>();
        userEntities.forEach(user->userModels.add(userMapper.convertEntityToModel((user))));
        return userModels;

    }
}
