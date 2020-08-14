package com.ns.bank.controller;

import com.ns.bank.model.*;
import com.ns.bank.service.ICustomerService;
import com.ns.bank.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping(path = "/api/transfers")
public class TransferController {

    @Autowired
    private ITransferService transferService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAllTransfers() {
        List<TransferModel> transferModelList = transferService.getAllTransfers();
        return new ResponseEntity<>(transferModelList,
                transferModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{transfer-id}")
    public ResponseEntity<?> getTransferById(@PathVariable("transfer-id") Long transferId, @PathVariable("account-number") Long accountNumber) {
        if (transferService.checkTransferIdExists(transferId)) {
            TransferModel returnData = transferService.getTransferById(transferId);
            if (nonNull(returnData)) {
                return new ResponseEntity<>(returnData, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Data is Null", HttpStatus.NO_CONTENT);
            }
        } else {

            return new ResponseEntity<>( "Deposit with Id" + transferId + "doesn't exist", HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping(path = "/{transfer-id}/status")
    public ResponseEntity<?> changeTransferStatus(@PathVariable("transfer-id") Long transferId, @RequestBody TransferModel transferModel) {

        if (nonNull(transferModel)) {
            System.out.println("inside if.." + transferModel.getStatusModel().getId());
        }
        System.out.println("statusId::" + transferModel.getStatusModel().getId());
        if (transferService.checkTransferIdExists(transferId)) {
            int result = transferService.updateTransferStatus(transferModel.getStatusModel().getId().longValue(), transferId);
            if (result != 0) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTransfer(@RequestBody TransferModel transferModel) throws Exception {
        HttpStatus status;
        StatusModel statusModel = new StatusModel();
        statusModel.setId(2);
        transferModel.setStatusModel(statusModel);
        TransferModel transferModel1 = transferService.createTransfer(transferModel);
        if (nonNull(transferModel1)) {
            if (nonNull(transferModel1.getAmount())) {
                if (customerService.checkAccountNumberExists(transferModel.getCustomerModel().getAccountNo())) {
                    if (customerService.checkAccountNumberExists(transferModel.getReceiverAccountNumber())) {
                        Double balance = customerService.getBalanceById(transferModel.getCustomerModel().getAccountNo());
                        if (balance >= transferModel.getAmount()) {
                            //balance = balance - transferModel.getAmount()
                            int result = customerService.updateBalanceByAccountNumber(-transferModel.getAmount(), transferModel.getCustomerModel().getAccountNo());
                            //Double receiverAccBalance = customerService.getBalanceById(transferModel.getReceiverAccountNumber());
                            //receiverAccBalance = receiverAccBalance + transferModel.getAmount();
                            int result1 = customerService.updateBalanceByAccountNumber(transferModel.getAmount(), transferModel.getReceiverAccountNumber());
                            if (result > 0 && result1 > 0) {
                                int value = transferService.updateTransferStatus(6L, transferModel1.getId());
                                status = value > 0 ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                                return new ResponseEntity<>(transferModel1, status);
                            } else if (result > 0 && result1 == 0) {
                                int value = transferService.updateTransferStatus(2L, transferModel1.getId());
                                status = value > 0 ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                                return new ResponseEntity<>(transferModel1, status);
                            } else if (result == 0 && result1 == 0) {
                                int value = transferService.updateTransferStatus(8L, transferModel1.getId());
                                if (value > 0) {
                                    // Double balance1 = customerService.getBalanceById(transferModel.getCustomerModel().getAccountNo());
                                    //balance1 = balance1 + transferModel1.getAmount();
                                    int result2 = customerService.updateBalanceByAccountNumber(transferModel1.getAmount(), transferModel.getCustomerModel().getAccountNo());
                                    if (result2 > 0) {
                                        int value2 = transferService.updateTransferStatus(9L, transferModel1.getId());
                                        status = value2 > 0 ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                                        return new ResponseEntity<>("Deducted amount refunded", status);
                                    }
                                }
                                status = value > 0 ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                                return new ResponseEntity<>(transferModel1, status);
                            }
                        } else {
                            int value3 = transferService.updateTransferStatus(8L, transferModel1.getId());
                            status = value3 > 0 ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                            return new ResponseEntity<>("Insufficient Balance", status);
                            //throw new Exception("Insufficient Funds ");
                        }
                    } else {
                        throw new Exception("Receiver Account number" + transferModel.getReceiverAccountNumber() + "doesn't exist");
                    }
                } else {
                    throw new Exception("Account number" + transferModel.getCustomerModel().getAccountNo() + "doesn't exist");
                }

            }
        }
        return new ResponseEntity<>(transferModel1, HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(path = "/status/{status-id}")
    public ResponseEntity<?> getAllTransfersByStatusId(@PathVariable("status-id") Long statusId) {
        List<TransferModel> transferModelList = transferService.getAllTransferByStatusId(statusId);
        return new ResponseEntity<>(transferModelList,
                transferModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "{/customer/account-number}")
    public ResponseEntity<?> getAllTransfersByAccountNumber(@PathVariable("account-number") Long accountNumber) {
        List<TransferModel> transferModelList = transferService.getTransfersByAccountNumber(accountNumber);
        System.out.println("transferList" + transferModelList);
        return new ResponseEntity<>(transferModelList,
                transferModelList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }


}