package com.ns.bank.service;

import com.ns.bank.model.CustomerModel;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<CustomerModel> getAllCustomers();
    CustomerModel getCustomerById(Long customerId);
    boolean checkAccountNumberExists(Long accountNumber);
    CustomerModel createCustomer(CustomerModel customerModel);
    List<CustomerModel> getCustomersByStatusId(Long statusId);
    List<CustomerModel> getCustomersByBranchId(Long branchId);
    List<CustomerModel> getCustomersByAccountTypeId(Long accountTypeId);
    CustomerModel getCustomerByEmailAndPassword(String email, String Password);


}
