package com.ns.bank.controller;

import com.ns.bank.entity.Withdraw;
import com.ns.bank.model.DepositModel;
import com.ns.bank.model.RowStatusModel;
import com.ns.bank.model.StatusModel;
import com.ns.bank.model.WithdrawModel;
import com.ns.bank.service.ICustomerService;
import com.ns.bank.service.IWithdrawService;
import com.ns.bank.service.impl.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping(path = "/api/withdraws")
public class WithdrawController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IWithdrawService withdrawService;

    @GetMapping
    public ResponseEntity<?> getAllWithdraws() {
        List<WithdrawModel> withdrawModelList = withdrawService.getAllWithdraws();
        return new ResponseEntity<>(withdrawModelList,
                withdrawModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/{withdraw-id}")
    public ResponseEntity<?> getWithdrawById(@PathVariable("withdraw-id") Long withdrawId, @PathVariable("account-number") Long accountNumber) {
        String message = null;
        if (withdrawService.checkWithdrawIdExists(withdrawId)) {
            WithdrawModel returnData = withdrawService.getWithdrawById(withdrawId);
            if (nonNull(returnData)) {
                return new ResponseEntity<>(returnData, HttpStatus.OK);
            } else {
                message = "Data is Null";
                return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
            }
        } else {
            message = "Deposit with Id" + withdrawId + "doesn't exist";
            return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping(path = "/{withdraw-id}/status")
    public ResponseEntity<?> changeWithdrawStatus(@PathVariable("withdraw-id") Long withdrawId, @RequestBody RowStatusModel rowStatusModel) {
        Integer statusId = 0;
        if (nonNull(rowStatusModel)) {
            statusId = rowStatusModel.getId();
        }
        System.out.println("statusId::" + statusId);
        if (withdrawService.checkWithdrawIdExists(withdrawId)) {
            int result = withdrawService.updateWithdrawStatus(statusId.longValue(), withdrawId);
            if (result != 0) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdraw(@RequestBody WithdrawModel withdrawModel) throws Exception {
        HttpStatus status = null;
        StatusModel statusModel = new StatusModel();
        statusModel.setId(2);
        withdrawModel.setStatusModel(statusModel);
        WithdrawModel withdrawModel1 = withdrawService.createWithdraw(withdrawModel);
        if (nonNull(withdrawModel1)) {
            if (nonNull(withdrawModel1.getWithdrawAmount())) {
                if (customerService.checkAccountNumberExists(withdrawModel.getCustomerModel().getAccountNo())) {
                    Double balance = customerService.getBalanceById(withdrawModel.getCustomerModel().getAccountNo());
                    if (balance > withdrawModel1.getWithdrawAmount()) {
                       // balance = balance - withdrawModel1.getWithdrawAmount();
                        int result = customerService.updateBalanceByAccountNumber(- withdrawModel1.getWithdrawAmount(), withdrawModel.getCustomerModel().getAccountNo());
                        if (result > 0) {
                            int value = withdrawService.updateWithdrawStatus(6L, withdrawModel1.getId());
                            status = value > 0 ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                            return new ResponseEntity<>(withdrawModel1, status);
                        } else {
                            int value = withdrawService.updateWithdrawStatus(8L, withdrawModel1.getId());
                            status = value > 0 ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                            Double userBalance = customerService.getBalanceById(withdrawModel.getCustomerModel().getAccountNo());
                           // userBalance = userBalance + withdrawModel1.getWithdrawAmount();
                            int result1 = customerService.updateBalanceByAccountNumber(withdrawModel1.getWithdrawAmount(), withdrawModel.getCustomerModel().getAccountNo());
                            if (result1 > 0) {
                                int value1 = withdrawService.updateWithdrawStatus(9L, withdrawModel1.getId());
                                status = value1 > 0 ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                                return new ResponseEntity<>(withdrawModel1, status);
                            } else {
                                int value2 = withdrawService.updateWithdrawStatus(2L, withdrawModel1.getId());
                                status = value2 > 0 ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                            }
                        }
                        return new ResponseEntity<>(withdrawModel1, status);
                    } else {
                        throw new Exception("Insufficient Balance ");
                    }
                }
            } else {
                throw new Exception("Account number" + withdrawModel.getCustomerModel().getAccountNo() + "doesn't exist");
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(path = "/status/{status-id}")
    public ResponseEntity<?> getAllWithdrawsByStatusId(@PathVariable("status-id") Long statusId) {
        List<WithdrawModel> withdrawModelList = withdrawService.getAllWithdrawByStatusId(statusId);
        return new ResponseEntity<>(withdrawModelList,
                withdrawModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "{/customer/account-number}")
    public ResponseEntity<?> getAllWithdrawsByAccountNumber(@PathVariable("account-number") Long accountNumber) {
        List<WithdrawModel> withdrawModelList = withdrawService.getWithdrawsByAccountNumber(accountNumber);
        System.out.println("withdrawList" + withdrawModelList);
        return new ResponseEntity<>(withdrawModelList,
                withdrawModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}