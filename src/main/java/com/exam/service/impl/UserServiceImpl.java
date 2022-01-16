package com.exam.service.impl;

import com.exam.repo.*;
import  com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

//to define service class user service
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local !=null){
            System.out.println("User is already there!!");
            throw new Exception("User exits ");
        }
        else{
            //assining all role defined for a users to user
            for(UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }
            //saving role to user
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }



}
