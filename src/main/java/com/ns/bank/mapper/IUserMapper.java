package com.ns.bank.mapper;

import com.ns.bank.entity.User;
import com.ns.bank.model.UserModel;

public interface IUserMapper {
    User convertModelToEntity(UserModel userModel);
    UserModel convertEntityToModel(User userEntity);
}
