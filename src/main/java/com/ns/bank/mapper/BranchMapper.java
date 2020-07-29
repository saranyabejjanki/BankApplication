package com.ns.bank.mapper;

import com.ns.bank.entity.*;
import com.ns.bank.model.BranchModel;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;


public class BranchMapper implements IBranchMapper {

    @Autowired
    private  AddressMapper addressMapper;

    @Override
    public Branch convertModelToEntity(BranchModel branchModel) {
   /*     Branch branchEntity =new Branch();
        Address addressEntity=new Address();
        RowStatus rowStatusEntity=new RowStatus();
        User userEntity=new User();

        if(nonNull(branchModel)) {
            branchEntity.setName(branchModel.getName());
            branchEntity.setPhoneNo(branchModel.getPhoneNo());
            branchEntity.setAddress(addressMapper.convertModelToEntity(branchModel.getAddressModel()));
            branchEntity.setCreatedDate(branchModel.getCreatedDate());
            if(nonNull(branchModel.getCustomerModels())) {
                Set<Customer> customers=branchModel.getCustomerModels().stream().map( customer-> {
                    Customer customerEntity=new Customer();
                    customerEntity.setAccountNo(customer.getAccountNo());
                    customerEntity.setId(customer.getId());
                  //customerEntity.setAddress(customer.getAddressModel());
              //  } ).collect(Collectors.toSet());
         //   }
            branchEntity.setCustomers();


        }
        return branchEntity;*/
    return  null;

}

    @Override
    public BranchModel convertEntityToModel(Branch branchEntity) {
        return null;
    }
}
