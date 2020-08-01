package com.ns.bank.service.impl;

import com.ns.bank.entity.User;
import com.ns.bank.mapper.UserMapper;
import com.ns.bank.model.UserModel;
import com.ns.bank.repository.UserRepository;
import com.ns.bank.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements IUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel createUser(UserModel userModel) {

        User userEntity = new User() ;
        UserModel userModel1 = new UserModel();
        if(Objects.nonNull(userModel)){
            userEntity = userMapper.convertModelToEntity(userModel);
        }
        if(Objects.nonNull(userEntity)){
            userEntity = userRepository.save(userEntity);
        }
        if(Objects.nonNull(userEntity)){
            userModel1 = userMapper.convertEntityToModel(userEntity);
        }
        return userModel1;
    }

    @Override
    public UserModel updateUser(UserModel userModel) {

            User userEntity = new User() ;
            UserModel userModel1 = new UserModel();
            if(Objects.nonNull(userModel)){
                userEntity = userMapper.convertModelToEntity(userModel);
            }
            if(Objects.nonNull(userEntity)){
                userEntity = userRepository.save(userEntity);
            }
            if(Objects.nonNull(userEntity)){
                userModel1 = userMapper.convertEntityToModel(userEntity);
            }
            return userModel1;
    }

    @Override
    public int changeUserStatus(Long userId, Integer rowStatusId) {
        return userRepository.updateUserStatus(userId,rowStatusId);
    }

    @Override
    public List<UserModel> getAllUsersByRoleId(Long roleId) {
        List<User> users = userRepository.findAllByRoleId(roleId);
        List<UserModel> userModels = new ArrayList<>();
        if(Objects.nonNull(users)){
            for(User user:users){
                userModels.add(userMapper.convertEntityToModel(user));
            }
        }
        return userModels;
    }

    @Override
    public List<UserModel> getAllUsersByBranchId(Long branchId) {
        List<User> users = userRepository.findAllByBranchId(branchId);
        List<UserModel> userModels = new ArrayList<>();
        if(Objects.nonNull(users)){
            for(User user:users){
                userModels.add(userMapper.convertEntityToModel(user));
            }
        }
        return userModels;
    }

    @Override
    public List<UserModel> getAllUsersByRowStatusId(Long rowStatusId) {
        List<User> users = userRepository.findAllByRowStatusId(rowStatusId);
        List<UserModel> userModels = new ArrayList<>();
        if(Objects.nonNull(users)){
            for(User user:users){
                userModels.add(userMapper.convertEntityToModel(user));
            }
        }
        return userModels;
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserModel> userModels = new ArrayList<>();
        if(Objects.nonNull(users)){
            for(User user:users){
                userModels.add(userMapper.convertEntityToModel(user));
            }
        }
        return userModels;
    }

    @Override
    public UserModel getUserById(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        UserModel userModel = new UserModel();
        userModel = userMapper.convertEntityToModel(user.get());
        return userModel;
    }

    @Override
    public Boolean checkUserExist(Long userId) {
        return userRepository.existsById(userId);
    }


}
