package com.ns.bank.controller;

import com.ns.bank.entity.User;
import com.ns.bank.model.UserModel;
import com.ns.bank.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllUsers(){
        List<UserModel> returnData = userService.getAllUsers();
        if(Objects.nonNull(returnData)){
            return new ResponseEntity<>(returnData,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel){
        UserModel returnData = userService.createUser(userModel);
        if(Objects.nonNull(returnData)){
            return new ResponseEntity<>(returnData, HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(path = "/{user-id}",produces = "application/json")
    public ResponseEntity<?> getUserById(@PathVariable("user-id") Long userId){
        if(userService.checkUserExist(userId)){
            UserModel returnData =  userService.getUserById(userId);
            if(Objects.nonNull(returnData)){
                return new ResponseEntity<>(returnData, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(path = "{user-id}")
    public ResponseEntity<?> updateUser(@PathVariable("user-id") Long userId,@RequestBody UserModel userModel){
        if(Objects.nonNull(userId)){
            if(userService.checkUserExist(userId)){
                userModel.setId(userId);
                UserModel returnData = userService.updateUser(userModel);
                if(Objects.nonNull(returnData)){
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

    @PatchMapping(path = "{user-id}/change-user-status")
    public ResponseEntity<?> changeUserStatus(@PathVariable("user-id") Long userId,UserModel userModel){
            if(userService.checkUserExist(userId)){
                if(Objects.nonNull(userModel.getRowStatusModel())){
                    int result = userService.changeUserStatus(userId,userModel.getRowStatusModel().getId());
                if(result!=0){
                    return new ResponseEntity<>(HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
                }
                else
                    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
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
        List<UserModel> userModels = userService.getAllUsersByRoleId(branchId);
        return  new  ResponseEntity<>(userModels,userModels.size()>0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/row-status/{row-status-id}")
    public ResponseEntity<?> getAllUsersByRowStatusId(@PathVariable("row-status-id") Long rowStatusId){
        List<UserModel> userModels = userService.getAllUsersByRowStatusId(rowStatusId);
        return  new  ResponseEntity<>(userModels,userModels.size()>0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}