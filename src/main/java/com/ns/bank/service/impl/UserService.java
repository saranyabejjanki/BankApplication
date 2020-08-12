package com.ns.bank.service.impl;

import com.ns.bank.entity.User;
import com.ns.bank.mapper.RoleMapper;
import com.ns.bank.mapper.RowStatusMapper;
import com.ns.bank.mapper.UserMapper;
import com.ns.bank.model.MyUserDetails;
import com.ns.bank.model.UserModel;
import com.ns.bank.repository.UserRepository;
import com.ns.bank.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UserService implements IUserService , UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RowStatusMapper rowStatusMapper;

    @Override
    public UserModel createUser(UserModel userModel) {

        User userEntity = new User();
        UserModel userModel1 = new UserModel();
        if (Objects.nonNull(userModel)) {
            userEntity = userMapper.convertModelToEntity(userModel);
        }
        if (Objects.nonNull(userEntity)) {
            userEntity = userRepository.save(userEntity);
        }
        if (Objects.nonNull(userEntity)) {
            userModel1 = userMapper.convertEntityToModel(userEntity);
        }
        return userModel1;
    }

    @Override
    public UserModel updateUser(UserModel userModel) {

        User userEntity = new User();
        UserModel userModel1 = new UserModel();
        if (Objects.nonNull(userModel)) {
            userEntity = userMapper.convertModelToEntity(userModel);
        }
        if (Objects.nonNull(userEntity)) {
            userEntity = userRepository.save(userEntity);
        }
        if (Objects.nonNull(userEntity)) {
            userModel1 = userMapper.convertEntityToModel(userEntity);
        }
        return userModel1;
    }

    @Override
    public int changeUserStatus(Long userId, Integer rowStatusId) {
        return userRepository.updateUserStatus(userId, rowStatusId);
    }

    @Override
    public List<UserModel> getAllUsersByRoleId(Long roleId) {
        List<User> users = userRepository.findAllByRoleId(roleId);
        List<UserModel> userModels = new ArrayList<>();
        if (Objects.nonNull(users)) {
            for (User user : users) {
                userModels.add(userMapper.convertEntityToModel(user));
            }
        }
        return userModels;
    }

    @Override
    public List<UserModel> getAllUsersByBranchId(Long branchId) {
        List<User> users = userRepository.findAllByBranchId(branchId);
        List<UserModel> userModels = new ArrayList<>();
        if (Objects.nonNull(users)) {
            for (User user : users) {
                userModels.add(userMapper.convertEntityToModel(user));
            }
        }
        return userModels;
    }

    @Override
    public List<UserModel> getAllUsersByRowStatusId(Long rowStatusId) {
        List<User> users = userRepository.findAllByRowStatusId(rowStatusId);
        List<UserModel> userModels = new ArrayList<>();
        if (Objects.nonNull(users)) {
            for (User user : users) {
                userModels.add(userMapper.convertEntityToModel(user));
            }
        }
        return userModels;
    }

    @Override
    public UserModel findUserByEmailAndPassword(String email, String password) {
        Optional<User> userEntity = userRepository.findByEmailAndPassword(email, password);
        UserModel userModel = null;
        if (userEntity.isPresent()) {
            User user = userEntity.get();

            userModel = new UserModel(
                    user.getId(),
                    user.getName(),
                    user.getPassword(),
                    user.getPhone(),
                    user.getEmail(),
                    user.getGender(),

                    roleMapper.convertEntityToModel(user.getRole()),
                    rowStatusMapper.convertEntityToModel(user.getRowStatus())
            );
            return userModel;
        } else
            return userModel;
    }

    @Override
    public UserModel findUserByEmail(String email) {
        Optional<User> user= userRepository.findByEmail(email);
        return userMapper.convertEntityToModel(user.get());
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserModel> userModels = new ArrayList<>();
        if (Objects.nonNull(users)) {
            for (User user : users) {
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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = findUserByEmail(username);
        System.out.println("inside user service,...");
     /* Collection authorities =  new ArrayList<>();
      authorities.add(userModel.getRoleModel().getName());*/
        if (username.equals(userModel.getEmail())) {
            //  return  new UserModel();
            return new MyUserDetails(userModel);
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }

}