package com.ns.bank.mapper;

import com.ns.bank.entity.*;
import com.ns.bank.model.BranchModel;
import com.ns.bank.model.CustomerModel;
import com.ns.bank.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Component
public class BranchMapper implements IBranchMapper {

    @Autowired
    private  IAddressMapper addressMapper;
    @Autowired
    private  ICustomerMapper customerMapper;
    @Autowired
    private  IUserMapper userMapper;

    @Autowired
    private  IRowStatusMapper rowStatusMapper;

    @Override
    public Branch convertModelToEntity(BranchModel branchModel) {

        Branch branchEntity =new Branch();
        if(nonNull(branchModel)) {
            branchEntity.setBranchCode(branchModel.getBranchCode());
            branchEntity.setName(branchModel.getName());
            branchEntity.setPhoneNo(branchModel.getPhoneNo());
            if(Objects.nonNull(branchModel.getAddressModel()))
            branchEntity.setAddress(addressMapper.convertModelToEntity(branchModel.getAddressModel()));
            branchEntity.setCreatedDate(branchModel.getCreatedDate());
            if(Objects.nonNull(branchModel.getRowStatusModel()))
            branchEntity.setRowStatus(rowStatusMapper.convertModelToEntity(branchModel.getRowStatusModel()));
         /*   if(nonNull(branchModel.getCustomerModels())) {
                Set<Customer> customers = branchModel.getCustomerModels().stream().map(customer -> {
                    Customer customerEntity = customerMapper.convertModelToEntity(customer);
                    return customerEntity;
                }).collect(Collectors.toSet());
                branchEntity.setCustomers(customers);
            }
            if(nonNull(branchModel.getUserModels())) {
                Set<User> users = branchModel.getUserModels().stream().map(user -> {
                   User userEntity = userMapper.convertModelToEntity(user);
                    return userEntity;
                }).collect(Collectors.toSet());
                branchEntity.setUsers(users);
            }

          */

        }
        return branchEntity;

}

    @Override
    public BranchModel convertEntityToModel(Branch branchEntity) {

        BranchModel branchModel =new BranchModel();
        if(nonNull(branchModel)) {
            branchModel.setBranchCode(branchEntity.getBranchCode());
            branchModel.setName(branchEntity.getName());
            branchModel.setPhoneNo(branchEntity.getPhoneNo());
            if(Objects.nonNull(branchEntity.getAddress()))
            branchModel.setAddressModel(addressMapper.convertEntityToModel(branchEntity.getAddress()));
            branchModel.setCreatedDate(branchEntity.getCreatedDate());
            if(Objects.nonNull(branchEntity.getRowStatus()))
            branchModel.setRowStatusModel(rowStatusMapper.convertEntityToModel(branchEntity.getRowStatus()));
          /* if(nonNull(branchEntity.getCustomers())) {
                Set<CustomerModel> customers = branchEntity.getCustomers().stream().map(customerEntity -> {
                    CustomerModel customerModel = customerMapper.convertEntityToModel(customerEntity);
                    return customerModel;
                }).collect(Collectors.toSet());
                branchModel.setCustomerModels(customers);
            }
            if(nonNull(branchEntity.getUsers())) {
                Set<UserModel> users = branchEntity.getUsers().stream().map(user -> {
                    UserModel userModel = userMapper.convertEntityToModel(user);
                    return userModel;
                }).collect(Collectors.toSet());
                branchModel.setUserModels(users);
            }
           */
        }
        return branchModel;
    }
}
