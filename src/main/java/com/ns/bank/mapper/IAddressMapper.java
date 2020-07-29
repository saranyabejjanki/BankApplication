package com.ns.bank.mapper;

import com.ns.bank.entity.Address;
import com.ns.bank.model.AddressModel;
import com.ns.bank.model.UserModel;
import com.ns.bank.repository.AddressRepository;

public interface IAddressMapper {

    Address convertModelToEntity(AddressModel addressModel);
    AddressModel convertEntityToModel(Address addressEntity);
}
