package com.ns.bank.controller;

import com.ns.bank.model.LoanTypeModel;
import com.ns.bank.service.ILoanTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(path = "api/loan-types")
@CrossOrigin(origins = "*")
public class LoanTypeController {

    @Autowired
    private ILoanTypeService loanTypeService;
    @GetMapping()
    public ResponseEntity<?> getAllLoanTypes(){
        List<LoanTypeModel> loanTypeList = loanTypeService.getAllLoans();
        return new ResponseEntity<>(loanTypeList, loanTypeList.size()>0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "{loan-type-id}")
    public ResponseEntity<?> getLoanTypeById(@PathVariable("loan-type-id") Integer loanTypeId){
        if(loanTypeId!=null){
            LoanTypeModel loanTypeModel = loanTypeService.getLoanTypeByLoanId(loanTypeId);
            return new ResponseEntity<>(loanTypeModel, Objects.nonNull(loanTypeModel) ? HttpStatus.OK :
                    HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }
    }

}