package com.ns.bank.mapper;

import com.ns.bank.entity.Customer;
import com.ns.bank.entity.User;
import com.ns.bank.model.CustomerModel;
import com.ns.bank.model.UserModel;

public interface ICustomerMapper {
    Customer convertModelToEntity(CustomerModel customerModel);
    CustomerModel convertEntityToModel(Customer customerEntity);
}
