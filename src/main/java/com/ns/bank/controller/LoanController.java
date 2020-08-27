package com.ns.bank.controller;
import com.ns.bank.model.LoanModel;
import com.ns.bank.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/loans")
public class LoanController {

    @Autowired
    private ILoanService loanService;

    @GetMapping()
    public ResponseEntity<?> getAllLoans() {
        List<LoanModel> loans = loanService.getAllLoans();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @GetMapping(path = "/customer/{customer-id}")
    public ResponseEntity<?> getLoansByCustomerId(@PathVariable("customer-id") Long customerId) {
        if (loanService.existByCustomerId(customerId)) {
            List<LoanModel> loans = loanService.getAllLoansByCustomerId(customerId);
            return new ResponseEntity<>(loans, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/{loan-id}")
    public ResponseEntity<?> getLoanById(@PathVariable("loan-id") Long loanId) {
        if (loanService.existByLoanId(loanId)) {
            LoanModel loanModel = loanService.getLoanByLoanId(loanId);
            return new ResponseEntity<>(loanModel, Objects.nonNull(loanModel) ? HttpStatus.OK : HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping()
    public ResponseEntity<?> createLoan(@RequestBody LoanModel loanModel){
        if(Objects.nonNull(loanModel)){
          LoanModel loanModel1 =  loanService.createLoan(loanModel);
          return new ResponseEntity<>(loanModel1,  HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PutMapping(path = "/{loan-id}")
    public ResponseEntity<?> updateLoan(@PathVariable("loan-id") Long loanId,@RequestBody LoanModel loanModel){
     if(Objects.nonNull(loanId)){
         if(loanService.existByLoanId(loanId)){
             loanModel.setId(loanId);
             LoanModel loanModel1 =  loanService.updateLoand(loanModel);
             return new ResponseEntity<>(loanModel1,HttpStatus.OK);
         }else
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     else
         return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path = "/{loan-id}/status/{status-id}")
    public ResponseEntity<?> updateLoanStatus(@PathVariable("loan-id") Long loanId,
                                              @PathVariable("status-id") Long statusId,@RequestBody LoanModel loanModel){
        if(loanService.existByLoanId(loanId)){
           int data = loanService.updateLoanStatus(statusId,loanId);
           return new ResponseEntity<>(data,HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
