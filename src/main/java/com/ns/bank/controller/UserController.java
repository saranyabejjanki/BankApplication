package com.ns.bank.controller;
import com.ns.bank.model.*;
import com.ns.bank.service.impl.CustomerService;
import com.ns.bank.service.impl.UserService;
import com.ns.bank.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;
import static java.util.Objects.nonNull;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllUsers(){
        List<UserModel> returnData = userService.getAllUsers();
        if(nonNull(returnData)){
            return new ResponseEntity<>(returnData,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value={"/login"},method= RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody LoginModel loginModel) throws Exception {
        Authentication authentication = null;
        int length=loginModel.getEmail().length();
    try {
        List<SimpleGrantedAuthority> authorities=null;
        if(loginModel.getEmail().endsWith("cus")) {
            if (loginModel.getCustomer()) {
                authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("Customer"));
            }
        }else {
            authorities = new ArrayList<>();
        }
           authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword(),authorities));
            } catch (BadCredentialsException e) {
                throw new Exception("bad credentials");
            }
        if (loginModel.getCustomer()) {
          CustomerDetails myUserDetails = (CustomerDetails) authentication.getPrincipal();
            final UserDetails userDetails = customerService.loadUserByUsername(loginModel.getEmail().substring(0,(length-3)));
            final String jwt = jwtUtil.generateToken(userDetails, loginModel.getCustomer());
          return ResponseEntity.ok(new CustomerAuthenticationResponse(jwt,myUserDetails.getAccountNo(),myUserDetails.getCustomerName(),myUserDetails.getUsername(),myUserDetails.getUsername(),myUserDetails.getCustomerModel().getBranchModel().getBranchCode()));

        } else {
             MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            final UserDetails userDetails = userService.loadUserByUsername(loginModel.getEmail());
            final String jwt = jwtUtil.generateToken(userDetails);

          return ResponseEntity.ok(new AuthenticationResponse(jwt, myUserDetails.getId(), myUserDetails.getName(), myUserDetails.getUserModel().getRoleModel().getName(), myUserDetails.getUsername()));

        }
    }

    @PostMapping(consumes = "application/json")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel){
        UserModel returnData = userService.createUser(userModel);
        if(nonNull(returnData)){
            return new ResponseEntity<>(returnData, HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(path = "/{user-id}",produces = "application/json")
    public ResponseEntity<?> getUserById(@PathVariable("user-id") Long userId){
        if(userService.checkUserExist(userId)) {
            UserModel returnData = userService.getUserById(userId);
            if (nonNull(returnData)) {
                return new ResponseEntity<>(returnData, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
           else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
    }
    @PutMapping(path = "{user-id}")
    public ResponseEntity<?> updateUser(@PathVariable("user-id") Long userId,@RequestBody UserModel userModel){
        if(nonNull(userId)){
            if(userService.checkUserExist(userId)){
                userModel.setId(userId);
                UserModel returnData = userService.updateUser(userModel);
                if(nonNull(returnData)){
                    return new ResponseEntity<>(returnData, HttpStatus.OK);
                }
                else
                    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PatchMapping(path = "{user-id}/change-user-status/{row-status-id}")
    public ResponseEntity<?> changeUserStatus(@PathVariable("user-id") Long userId,
                                              @PathVariable("row-status-id") Integer rowStatusId,
                                              UserModel userModel){
            if(userService.checkUserExist(userId)) {

                int result = userService.changeUserStatus(userId, rowStatusId);
                if (result != 0) {
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
                else
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping(path = "/roles/{role-id}")
    public ResponseEntity<?> getAllUsersByRoleId(@PathVariable("role-id") Long roleId){
        List<UserModel> userModels = userService.getAllUsersByRoleId(roleId);
        return  new  ResponseEntity<>(userModels,userModels.size()>0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/branch/{branch-id}")
    public ResponseEntity<?> getAllUsersByBranchId(@PathVariable("branch-id") Long branchId){
        List<UserModel> userModels = userService.getAllUsersByBranchId(branchId);
        return  new  ResponseEntity<>(userModels,userModels.size()>0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/row-status/{row-status-id}")
    public ResponseEntity<?> getAllUsersByRowStatusId(@PathVariable("row-status-id") Long rowStatusId){
        List<UserModel> userModels = userService.getAllUsersByRowStatusId(rowStatusId);
        return  new  ResponseEntity<>(userModels,userModels.size()>0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}