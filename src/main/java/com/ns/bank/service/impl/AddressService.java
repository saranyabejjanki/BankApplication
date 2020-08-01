package com.ns.bank.service.impl;

import com.ns.bank.entity.Address;
import com.ns.bank.mapper.AddressMapper;
import com.ns.bank.model.AddressModel;
import com.ns.bank.model.UserModel;
import com.ns.bank.repository.AddressRepository;
import com.ns.bank.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressModel> fetchAllAddresses() {

        List<Address> addressEntities= addressRepository.findAll();
        List<AddressModel> addressModels=new ArrayList<>();
        addressEntities.forEach(address -> addressModels.add(addressMapper.convertEntityToModel((address))));
        return addressModels;
    }

    @Override
    public Boolean checkIfAddressExists(Long addressId) {
        return addressRepository.existsById(addressId);
    }

    @Override
    public AddressModel fetchAddressById(Long addressId) {
        Optional<Address> addressEntity=addressRepository.findById(addressId);
        AddressModel addressModel=new AddressModel();
        if(Objects.nonNull(addressEntity))
            addressModel=addressMapper.convertEntityToModel(addressEntity.get());

        return addressModel;
    }

    @Override
    public AddressModel saveAddress(AddressModel addressModel) {
        Address addressEntity= new Address();
        Address responseAddressEntity=new Address();
        if(Objects.nonNull(addressModel))
            addressEntity=addressMapper.convertModelToEntity(addressModel);
        responseAddressEntity= addressRepository.save(addressEntity);

        AddressModel address=new AddressModel();
        address=addressMapper.convertEntityToModel(responseAddressEntity);

        return address;
    }

    @Override
    public AddressModel updateAddress(AddressModel addressModel) {
        AddressModel address1=null;
        Address updatedAddress=new Address();
        if(Objects.nonNull(addressModel)) {
           Optional<Address> address = addressRepository.findById(addressModel.getId());
            System.out.println(address.get());
            address.get().setState(addressModel.getState());
            address.get().setPinCode(addressModel.getPinCode());
            address.get().setStreet(addressModel.getStreet());
            address.get().setCountry(addressModel.getCountry());
            address.get().setCity(addressModel.getCity());
            System.out.println("updated address"+address.get());
           address1 = addressMapper.convertEntityToModel(addressRepository.save(address.get()));

        }
        return address1;
    }

    @Override
    public Boolean deleteAddressById(Long addressId) {
        if( addressRepository.existsById(addressId)){
            addressRepository.deleteById(addressId);
            return  true;
        }
        return false;
    }
}
