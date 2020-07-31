package com.ns.bank.mapper;

import com.ns.bank.entity.Branch;
import com.ns.bank.entity.User;
import com.ns.bank.model.BranchModel;
import com.ns.bank.model.UserModel;
import com.ns.bank.repository.RowStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserMapper implements IUserMapper {


    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private BranchMapper branchMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RowStatusMapper rowStatusMapper;


    @Override
    public User convertModelToEntity(UserModel userModel) {
        User userEntity = new User();
        if (Objects.nonNull(userModel)) {
            if (Objects.nonNull(userModel.getId())) {
                userEntity.setId(userModel.getId());
            }
            userEntity.setName(userModel.getName());
            userEntity.setEmail(userModel.getEmail());
            userEntity.setGender(userModel.getGender());
            userEntity.setPassword(userModel.getPassword());
            userEntity.setPhone(userModel.getPhone());
            if (Objects.nonNull(userModel.getAddressModel())) {
                userEntity.setAddress(addressMapper.convertModelToEntity(userModel.getAddressModel()));
            }
            if (Objects.nonNull(userModel.getBranchModel())) {
                userEntity.setBranch(branchMapper.convertModelToEntity(userModel.getBranchModel()));
            }
            if (Objects.nonNull(userModel.getRoleModel())) {
                userEntity.setRole(roleMapper.convertModelToEntity(userModel.getRoleModel()));
            }
            if (Objects.nonNull(userModel.getRowStatusModel())) {
                userEntity.setRowStatus(rowStatusMapper.convertModelToEntity(userModel.getRowStatusModel()));
            }
        }
        return userEntity;
    }

    @Override
    public UserModel convertEntityToModel(User userEntity) {
        UserModel userModel = new UserModel();
        if (Objects.nonNull(userEntity)) {
            if (Objects.nonNull(userEntity.getId())) {
                userModel.setId(userEntity.getId());
            }
            userModel.setName(userEntity.getName());
            userModel.setCreatedDate(userEntity.getCreatedDate());
            userModel.setEmail(userEntity.getEmail());
            userModel.setPassword(userEntity.getPassword());
            userModel.setGender(userEntity.getGender());
            userModel.setPhone(userEntity.getPhone());
            if (Objects.nonNull(userEntity.getAddress())) {
                userModel.setAddressModel(addressMapper.convertEntityToModel(userEntity.getAddress()));
            }
            if (Objects.nonNull(userEntity.getBranch())) {
                userModel.setBranchModel(branchMapper.convertEntityToModel(userEntity.getBranch()));
            }
            if (Objects.nonNull(userEntity.getRole())) {
                userModel.setRoleModel(roleMapper.convertEntityToModel(userEntity.getRole()));
            }
            if (Objects.nonNull(userEntity.getRowStatus())) {
                userModel.setRowStatusModel(rowStatusMapper.convertEntityToModel(userEntity.getRowStatus()));
            }
        }
        return userModel;
    }
}
