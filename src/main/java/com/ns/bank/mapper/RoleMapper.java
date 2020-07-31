package com.ns.bank.mapper;

import com.ns.bank.entity.Role;
import com.ns.bank.entity.User;
import com.ns.bank.model.RoleModel;
import com.ns.bank.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class RoleMapper {

    @Autowired
    private UserMapper userMapper;

   public Role convertModelToEntity(RoleModel roleModel){
        Role roleEntity = new Role();
        if(Objects.nonNull(roleModel)){
            if(Objects.nonNull(roleModel.getId())){
                roleEntity.setId(roleModel.getId());
            }
            roleEntity.setName(roleModel.getName());

        }
        return roleEntity;
    }

   public RoleModel convertEntityToModel(Role role){
        RoleModel roleModel = new RoleModel();
        if(Objects.nonNull(role)){
            if(Objects.nonNull(role.getId())){
                roleModel.setId(role.getId());
            }
            roleModel.setName(role.getName());
        }
        return roleModel;
    }
}
