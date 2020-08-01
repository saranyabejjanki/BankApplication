package com.ns.bank.service;

import com.ns.bank.model.AddressModel;
import com.ns.bank.model.UserModel;

import java.util.List;

public interface IAddressService {

    List<AddressModel> fetchAllAddresses();
    Boolean checkIfAddressExists(Long addressId);
    AddressModel fetchAddressById(Long addressById);
    AddressModel  saveAddress(AddressModel addressModel);
    AddressModel updateAddress(AddressModel addressModel);
    Boolean deleteAddressById(Long addressId);

}
