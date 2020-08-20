package com.ns.bank.controller;

import com.ns.bank.model.CustomerModel;
import com.ns.bank.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllCustomers() {
        List<CustomerModel> customerModelList = customerService.getAllCustomers();
        return new ResponseEntity<>(customerModelList,
                customerModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{account-number}")
    public ResponseEntity<?> getCustomerByAccountNumber(@PathVariable("account-number") Long accountNumber) {
        HttpStatus status;
        CustomerModel customerModel = null;
        if (customerService.checkAccountNumberExists(accountNumber)) {
            customerModel = customerService.getCustomerById(accountNumber);
            status = HttpStatus.OK;
        } else
            status = HttpStatus.NO_CONTENT;

        return new ResponseEntity<>(customerModel, status);
    }

    @PostMapping()
    public ResponseEntity<?> createCustomer(@RequestBody CustomerModel customerModel){
        customerModel = customerService.createCustomer(customerModel);
        HttpStatus status;
      //  if(Objects.nonNull(customerModel.getAccountNo())){
            status = HttpStatus.CREATED;
      //  }
        //else
           // status = HttpStatus.NOT_ACCEPTABLE;

        return new ResponseEntity<>(customerModel,status);
    }

    @PutMapping(path = "/{account-number}")
    public ResponseEntity<?> updateCustomer(@PathVariable("account-number") Long accountNumber,
                                            @RequestBody CustomerModel customerModel){
        customerModel.setAccountNo(accountNumber);
        customerModel = customerService.createCustomer(customerModel);
        return new ResponseEntity<>(customerModel,HttpStatus.OK);
    }

    @GetMapping(path = "/status/{status-id}")
    public ResponseEntity<?> getAllCustomersByStatusId(@PathVariable("status-id") Long statusId) {
        List<CustomerModel> customerModelList = customerService.getCustomersByStatusId(statusId);
        return new ResponseEntity<>(customerModelList,
                customerModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/branch/{branch-id}")
    public ResponseEntity<?> getAllCustomersByBranchId(@PathVariable("branch-id") Long branchId) {
        List<CustomerModel> customerModelList = customerService.getCustomersByStatusId(branchId);
        return new ResponseEntity<>(customerModelList,
                customerModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/account-type/{account-type-id}")
    public ResponseEntity<?> getAllCustomersByAccountTypeId(@PathVariable("account-type-id") Long accountTypeId) {
        List<CustomerModel> customerModelList = customerService.getCustomersByStatusId(accountTypeId);
        return new ResponseEntity<>(customerModelList,
                customerModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
    @GetMapping(path="/balance/{account-number}")
    public ResponseEntity<?> getAccountBalanceByAccountNumber(@PathVariable("account-number")Long accountNumber) {
        String message=null;
        if(customerService.checkAccountNumberExists(accountNumber)) {
            Double balance = customerService.getBalanceById(accountNumber);
            if (nonNull(balance)) {
                return new ResponseEntity<>(balance, HttpStatus.OK);
            }
            message="Data is Null";
            return new ResponseEntity<>(message,HttpStatus.NO_CONTENT);
        } else {
            message="AccountNumber doesn't exist";
            return new ResponseEntity<>(message,HttpStatus.NO_CONTENT);
        }
    }
}