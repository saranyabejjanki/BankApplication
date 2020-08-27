package com.ns.bank.controller;
import com.ns.bank.model.BranchModel;
import com.ns.bank.model.CustomerModel;
import com.ns.bank.model.MyUserDetails;
import com.ns.bank.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.nonNull;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private IBranchService branchService;
    //MyUserDetails user =(MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   /* Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    MyUserDetails jwtUser = (MyUserDetails) auth.getPrincipal();*/
    @RequestMapping(method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<BranchModel>> fetchAllBranches() {
        List<BranchModel> branchesList = branchService.fetchAllBranches();
        return new ResponseEntity<List<BranchModel>>(branchesList, branchesList.size() != 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }


    @GetMapping(path = "/{branch-code}")
   // @PreAuthorize("(hasAuthority('MANAGER') and #branchCode == principal.branchCode)or hasAuthority('ADMIN')" )
    public ResponseEntity<BranchModel> fetchBranchByCode(@PathVariable("branch-code") Long branchCode) throws Exception {
       // System.out.println("Inside Branch Code::"+jwtUser.getBranchCode());
        if (branchService.checkIfBranchExists(branchCode)) {
            BranchModel branchModel = branchService.fetchBranchByCode(branchCode);
            return new ResponseEntity<BranchModel>(branchModel, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "count")
    public ResponseEntity<?> getBranchesCount(){
        Integer count = branchService.getAllBranchesCount();
        return new ResponseEntity(count, HttpStatus.OK);
    }
    @GetMapping(path="branch-balance")
    public ResponseEntity<?> getBalanceByBranchWise(){
        List<Object> data = branchService.getAllBranchesBalance();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping(path = "/{branch-code}/customers")
   // @PreAuthorize("(hasAuthority('MANAGER') and #branchCode == principal.branchCode) or hasAuthority('ADMIN')" )
    public ResponseEntity<List<CustomerModel>> fetchAllCustomersByCode(@PathVariable("branch-code") Long branchCode) throws Exception {
        List<CustomerModel>  customers=new ArrayList<>();
        if (branchService.checkIfBranchExists(branchCode)) {
            customers= branchService.getAllCustomersByBranchCode(branchCode);
        }
        return new ResponseEntity<List<CustomerModel>>(customers, customers.size()>0?HttpStatus.OK:HttpStatus.NO_CONTENT);
    }


    @PostMapping(path = "/create",consumes ={"application/json"})
   // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> createBranch(@RequestBody BranchModel branchModel) throws Exception {
        HttpStatus status;
        BranchModel branch = branchService.saveBranch(branchModel);
        System.out.println(branch);
        status = nonNull(branch) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(branch,status);
    }

    @PutMapping(path="/{branch-code}")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateBranch(@PathVariable("branch-code") Long branchCode,@RequestBody BranchModel branchModel) throws Exception{
        HttpStatus status;
        if(branchService.checkIfBranchExists(branchCode)){
           BranchModel branch= branchService.updateBranch(branchModel);
            status = nonNull(branch) ? HttpStatus.OK: HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(status);
        }
        else{
            //  throw new UserNotFoundException("User id '" + userId + "' does not exist");
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

//
//    @DeleteMapping(path="/{branch-code}")
//    public ResponseEntity<?> deleteBranchByCode(@PathVariable("branch-code") Long branchCode) throws Exception {
//        HttpStatus status;
//        if (branchService.checkIfBranchExists(branchCode)) {
//            Boolean value = branchService.deleteBranchByBranchCode(branchCode);
//            status = value == true ? HttpStatus.NO_CONTENT : HttpStatus.NOT_ACCEPTABLE;
//            return new ResponseEntity<>(value, status);
//        } else {
//            //throw new AddressNotFoundException("User id '" + userId + "' does not exist");
//            return null;
//        }
//
//    }

}
