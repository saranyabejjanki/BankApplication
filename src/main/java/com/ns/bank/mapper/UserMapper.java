package com.ns.bank.mapper;

import com.ns.bank.entity.Branch;
import com.ns.bank.entity.User;
import com.ns.bank.model.BranchModel;
import com.ns.bank.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements  IUserMapper{


    @Override
    public User convertModelToEntity(UserModel userModel) {
        return null;
    }

    @Override
    public UserModel convertEntityToModel(User userEntity) {
        return null;
    }
}
