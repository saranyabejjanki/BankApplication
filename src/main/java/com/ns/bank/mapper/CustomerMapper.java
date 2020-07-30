package com.ns.bank.mapper;

import com.ns.bank.entity.Customer;
import com.ns.bank.model.CustomerModel;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper  implements ICustomerMapper{
    @Override
    public Customer convertModelToEntity(CustomerModel customerModel) {
        return null;
    }

    @Override
    public CustomerModel convertEntityToModel(Customer customerEntity) {
        return null;
    }
}
