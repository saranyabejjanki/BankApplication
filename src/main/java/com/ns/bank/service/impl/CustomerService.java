package com.ns.bank.service.impl;

import com.ns.bank.entity.Customer;
import com.ns.bank.mapper.CustomerMapper;
import com.ns.bank.model.CustomerDetails;
import com.ns.bank.model.CustomerModel;
import com.ns.bank.model.MyUserDetails;
import com.ns.bank.model.UserModel;
import com.ns.bank.repository.CustomerRepository;
import com.ns.bank.service.ICustomerService;
import org.omg.CORBA.CustomMarshal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService, UserDetailsService {

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

    @Override
    public CustomerModel getCustomerByEmailAndPassword(String email, String password) {
       Optional<Customer> customer= customerRepository.findByEmailAndPassword(email,password);
            CustomerModel customerModel=customerMapper.convertEntityToModel(customer.get());
            return  customerModel;
    }
    @Override
    public Double getBalanceById(Long accountNumber) {
       Double balance= customerRepository.findBalanceByAccountNo(accountNumber);
       return  balance;
    }

    @Override
    public Integer updateBalanceByAccountNumber(Double amount,Long accountNumber) {
        return  customerRepository.updateAccountBalanceByAccountNumber(amount,accountNumber);
    }

    public CustomerModel findCustomerByEmail(String email) {
        Optional<Customer> customer=customerRepository.findByEmail(email);
        Customer customer1=new Customer();
        if(customer.isPresent()){
            customer1=customer.get();
        }
        return customerMapper.convertEntityToModel(customer1);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("inside customer service username+"+username);
        //username=username.substring(3);
        CustomerModel  customerModel=findCustomerByEmail(username);
        System.out.println("inside customer...service inside load user");
        System.out.println("customerModel"+customerModel.toString());
        if (username.equals(customerModel.getEmail())) {

            //return new User(customerModel.getEmail(),customerModel.getPassword(),new ArrayList<>());
           //return new CustomerDetails(customerModel.getAccountNo(),customerModel.getName(),customerModel.getBranchModel().getBranchCode(),customerModel.getPassword(),customerModel.getEmail());
            return new CustomerDetails(customerModel);
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
        //return new User(customerModel.getEmail(),customerModel.getPassword(),new ArrayList<>());
    }
}
