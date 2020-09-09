package com.ns.bank.controller;

import com.ns.bank.entity.RowStatus;
import com.ns.bank.model.DepositModel;
import com.ns.bank.model.RowStatusModel;
import com.ns.bank.model.StatusModel;
import com.ns.bank.service.ICustomerService;
import com.ns.bank.service.IDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/deposits")
public class DepositController {
    @Autowired
    private IDepositService depositService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAllDeposits() {
        List<DepositModel> depositModelList = depositService.getAllDeposits();
        return new ResponseEntity<>(depositModelList,
                depositModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{deposit-id}")
    public ResponseEntity<?> getDepositById(@PathVariable("deposit-id") Long depositId, @PathVariable("account-number") Long accountNumber) {
        String message = null;
        if (depositService.checkDepositIdExists(depositId)) {
            DepositModel returnData = depositService.getDepositById(depositId);
            if (nonNull(returnData)) {
                return new ResponseEntity<>(returnData, HttpStatus.OK);
            } else {
                message = "Data is Null";
                return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
            }
        } else {
            message = "Deposit with Id" + depositId + "doesn't exist";
            return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping(path = "/{deposit-id}/status")
    public ResponseEntity<?> changeDepositStatus(@PathVariable("deposit-id") Long depositId, @RequestBody RowStatusModel rowStatusModel) {
        Integer statusId = 0;
        if (nonNull(rowStatusModel)) {
            statusId = rowStatusModel.getId();
        }
        System.out.println("statusId::" + statusId);
        if (depositService.checkDepositIdExists(depositId)) {
            int result = depositService.updateDepositStatus(statusId.longValue(), depositId);
            if (result != 0) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@RequestBody DepositModel depositModel) {
        // System.out.println("id"+depositModel.getStatusModel().getId());
        HttpStatus status = null;
        StatusModel statusModel = new StatusModel();
        statusModel.setId(2);
        depositModel.setStatusModel(statusModel);
        //System.out.println("depositModel"+depositModel);
        DepositModel depositModel1 = depositService.createDeposit(depositModel);
        // System.out.println("id"+depositModel1.getStatusModel().getId());
        if (nonNull(depositModel1)) {
            if (nonNull(depositModel1.getDepositAmount())) {
                if (customerService.checkAccountNumberExists(depositModel.getCustomerModel().getAccountNo())) {
                    Double balance = customerService.getBalanceById(depositModel.getCustomerModel().getAccountNo());
                    // balance = balance + depositModel1.getDepositAmount();
                    int result = customerService.updateBalanceByAccountNumber(depositModel1.getDepositAmount(), depositModel.getCustomerModel().getAccountNo());
                    if (result > 0) {
                        int value = depositService.updateDepositStatus(6L, depositModel1.getId());
                        //System.out.println("Value"+value+"UPDATE status of depositModel"+depositModel);
                        status = value > 0 ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                        return new ResponseEntity<>(depositModel1, status);
                    } else {
                        int value = depositService.updateDepositStatus(8L, depositModel1.getId());
                        status = value > 0 ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                        return new ResponseEntity<>(depositModel1, status);
                    }
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(path = "/status/{status-id}")
    public ResponseEntity<?> getAllDepositsByStatusId(@PathVariable("status-id") Long statusId) {
        List<DepositModel> depositModelList = depositService.getAllDepositByStatusId(statusId);
        return new ResponseEntity<>(depositModelList,
                depositModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/customer/{account-number}")
    public ResponseEntity<?> getAllDepositsByAccountNumber(@PathVariable("account-number") Long accountNumber) {
        List<DepositModel> depositModelList = depositService.getDepositsByAccountNumber(accountNumber);
        System.out.println("depositList" + depositModelList);
        return new ResponseEntity<>(depositModelList,
                depositModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "count/{account-number}")
    public ResponseEntity<?> getAllDepositsCountByAccountNumber(@PathVariable("account-number") Long accountNumber) {
        Integer count = depositService.getDepositsCountByAccountNumber(accountNumber);
        return new ResponseEntity<>(count,
                count > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }


}