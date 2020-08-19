package com.ns.bank.controller;

import com.ns.bank.model.AddressModel;
import com.ns.bank.model.UserModel;
import com.ns.bank.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @RequestMapping(method= RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public ResponseEntity<List<AddressModel>> fetchAllAddresses() {
        List<AddressModel> addressList = addressService.fetchAllAddresses();
        return new ResponseEntity<List<AddressModel>>(addressList, addressList.size()!=0 ? HttpStatus.OK: HttpStatus.NO_CONTENT);
    }


    @GetMapping(path = "/{address-id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public ResponseEntity<?> fetchAddressById(@PathVariable("address-id") Long addressId) throws Exception {
        if (addressService.checkIfAddressExists(addressId)) {
            AddressModel addressModel = addressService.fetchAddressById(addressId);
            return new ResponseEntity<>(addressModel, HttpStatus.OK);
        }   else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> createAddress(@RequestBody AddressModel addressModel) throws Exception {
        HttpStatus status;
        AddressModel address = addressService.saveAddress(addressModel);
        System.out.println(address);
        status = Objects.nonNull(address) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(address,status);
    }

    @PutMapping(path="/{address-id}")
    public ResponseEntity<?> updateAddress(@PathVariable("address-id") Long addressId,@RequestBody AddressModel addressModel) throws Exception{
        HttpStatus status;
        if(addressService.checkIfAddressExists(addressId)){
            AddressModel address= addressService.updateAddress(addressModel);
            status = Objects.nonNull(address) ? HttpStatus.OK: HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(status);
        }
        else{
          //  throw new UserNotFoundException("User id '" + userId + "' does not exist");
            return null;
        }
    }

//
//    @DeleteMapping(path="/{address-id}")
//    public ResponseEntity<?> deleteAddressById(@PathVariable("address-id") Long addressId) throws Exception {
//        HttpStatus status;
//        if (addressService.checkIfAddressExists(addressId)) {
//            Boolean value = addressService.deleteAddressById(addressId);
//            status = value == true ? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE;
//            return new ResponseEntity<>(value, status);
//        } else {
//            //throw new AddressNotFoundException("User id '" + userId + "' does not exist");
//            return null;
//        }

 //   }

}


