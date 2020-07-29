package com.ns.bank.mapper;

import com.ns.bank.entity.Address;
import com.ns.bank.model.AddressModel;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AddressMapper implements IAddressMapper {
    @Override
    public Address convertModelToEntity(AddressModel addressModel) {
      Address addressEntity =new Address();
        if(Objects.nonNull(addressModel)) {
            addressEntity.setCity(addressModel.getCity());
            addressEntity.setState(addressModel.getState());
            addressEntity.setCountry(addressModel.getCountry());
            addressEntity.setStreet(addressModel.getStreet());
            addressEntity.setPinCode(addressModel.getPinCode());
        }
        return addressEntity;
    }

    @Override
    public AddressModel convertEntityToModel(Address addressEntity) {
        AddressModel addressModel=new AddressModel();
        if(Objects.nonNull(addressEntity)) {
            addressModel.setId(addressEntity.getId());
            addressModel.setCity(addressEntity.getCity());
            addressModel.setCountry(addressEntity.getCountry());
            addressModel.setState(addressEntity.getState());
            addressModel.setStreet(addressEntity.getStreet());
            addressModel.setPinCode(addressEntity.getPinCode());
        }
        return  addressModel;
    }
}
