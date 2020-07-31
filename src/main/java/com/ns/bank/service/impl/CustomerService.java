package com.ns.bank.service.impl;

import com.ns.bank.entity.Customer;
import com.ns.bank.mapper.CustomerMapper;
import com.ns.bank.model.CustomerModel;
import com.ns.bank.repository.CustomerRepository;
import com.ns.bank.service.ICustomerService;
import org.omg.CORBA.CustomMarshal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<CustomerModel> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerModel> customerModels = new ArrayList<>();
        for(Customer customer:customers){
            customerModels.add(customerMapper.convertEntityToModel(customer));
        }
        return customerModels;
    }

    @Override
    public CustomerModel getCustomerById(Long accountNumber) {
        Optional<Customer> customer = customerRepository.findById(accountNumber);
        CustomerModel customerModel = new CustomerModel();
        if(customer.isPresent()){
            customerModel = customerMapper.convertEntityToModel(customer.get());
        }
        return customerModel;
    }

    @Override
    public boolean checkAccountNumberExists(Long accountNumber) {
        return customerRepository.existsById(accountNumber);
    }

    @Override
    public CustomerModel createCustomer(CustomerModel customerModel) {


        Customer customer = customerMapper.convertModelToEntity(customerModel);
        Customer customer1 = customerRepository.save(customer);
        customerModel = customerMapper.convertEntityToModel(customer1);
        return customerModel;
    }

    @Override
    public List<CustomerModel> getCustomersByStatusId(Long statusId) {
        List<Customer> customers = customerRepository.getAllCustomersByStatusId(statusId);
        List<CustomerModel> customerModels = new ArrayList<>();
        for(Customer customer:customers){
            customerModels.add(customerMapper.convertEntityToModel(customer));
        }
        return customerModels;
    }

    @Override
    public List<CustomerModel> getCustomersByBranchId(Long branchId) {
        List<Customer> customers = customerRepository.getAllCustomersByBranchId(branchId);
        List<CustomerModel> customerModels = new ArrayList<>();
        for(Customer customer:customers){
            customerModels.add(customerMapper.convertEntityToModel(customer));
        }
        return customerModels;
    }

    @Override
    public List<CustomerModel> getCustomersByAccountTypeId(Long accountTypeId) {
        List<Customer> customers = customerRepository.getAllCustomersByAccountTypeId(accountTypeId);
        List<CustomerModel> customerModels = new ArrayList<>();
        for(Customer customer:customers){
            customerModels.add(customerMapper.convertEntityToModel(customer));
        }
        return customerModels;
    }
}
