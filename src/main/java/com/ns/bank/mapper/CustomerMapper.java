package com.ns.bank.mapper;

import com.ns.bank.entity.Customer;
import com.ns.bank.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerMapper implements ICustomerMapper {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private BranchMapper branchMapper;
    @Autowired
    private AccountTypeMapper accountTypeMapper;
    @Autowired
    private StatusMapper statusMapper;

    @Override
    public Customer convertModelToEntity(CustomerModel customerModel) {
        Customer customer = new Customer();
        if (Objects.nonNull(customerModel)) {
            if (Objects.nonNull(customerModel.getAccountNo()))
                customer.setAccountNo(customerModel.getAccountNo());

            customer.setDob(customerModel.getDob());
            customer.setAccountCreatedDate(customerModel.getAccountCreatedDate());
            customer.setPassword(customerModel.getPassword());
            customer.setEmail(customerModel.getEmail());
            customer.setName(customerModel.getName());
            customer.setBalance(customerModel.getBalance());

            if (Objects.nonNull(customerModel.getAddressModel()))
                customer.setAddress(addressMapper.convertModelToEntity(customerModel.getAddressModel()));

            if (Objects.nonNull(customerModel.getBranchModel()))
                customer.setBranchName(branchMapper.convertModelToEntity(customerModel.getBranchModel()));

            if (Objects.nonNull(customerModel.getAccountTypeModel()))
                customer.setAccountType(accountTypeMapper.convertModelToEntity(customerModel.getAccountTypeModel()));

            if (Objects.nonNull(customerModel.getStatusModel()))
                customer.setStatus(statusMapper.convertModelToEntity(customerModel.getStatusModel()));

        }
        return customer;
    }

    @Override
    public CustomerModel convertEntityToModel(Customer customerEntity) {
        CustomerModel customerModel = new CustomerModel();
        if (Objects.nonNull(customerEntity)) {
            if (Objects.nonNull(customerEntity.getAccountNo()))
                customerModel.setAccountNo(customerEntity.getAccountNo());

            customerModel.setDob(customerEntity.getDob());
            customerModel.setAccountCreatedDate(customerEntity.getAccountCreatedDate());
            customerModel.setPassword(customerEntity.getPassword());
            customerModel.setEmail(customerEntity.getEmail());
            customerModel.setName(customerEntity.getName());
            customerModel.setBalance(customerEntity.getBalance());

            if (Objects.nonNull(customerEntity.getAddress()))
                customerModel.setAddressModel(addressMapper.convertEntityToModel(customerEntity.getAddress()));
            if (Objects.nonNull(customerEntity.getBranchName()))
                customerModel.setBranchModel(branchMapper.convertEntityToModel(customerEntity.getBranchName()));
            if (Objects.nonNull(customerEntity.getAccountType()))
                customerModel.setAccountTypeModel(accountTypeMapper.convertEntityToModel(customerEntity.getAccountType()));
            if (Objects.nonNull(customerEntity.getStatus()))
                customerModel.setStatusModel(statusMapper.convertEntityToModel(customerEntity.getStatus()));
        }
        return customerModel;
    }
}
