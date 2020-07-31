package com.ns.bank.service;
import com.ns.bank.entity.User;
import com.ns.bank.model.UserModel;

import java.util.List;

public interface IUserService {


    List<UserModel> getAllUsers();
    UserModel getUserById(Long userId);
    Boolean checkUserExist(Long userId);
    UserModel createUser(UserModel user);
    UserModel updateUser(UserModel user);
    int changeUserStatus(Long userId, Integer rowStatusId);
    List<UserModel> getAllUsersByRoleId(Long roleId);
    List<UserModel> getAllUsersByBranchId(Long branchId);
    List<UserModel> getAllUsersByRowStatusId(Long rowStatusId);
}
