package com.scm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.services.UserService;
import com.scm.repositories.UserRepo;
import com.scm.helpers.ResourceNotFoundEXception;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();   
        user.setUserId(userId);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUser(String userId) {
        return userRepo.findById(userId);
    }

    @Override
    public Optional<User> updateUser(User user) {
         User user1 = userRepo.findById(user.getUserId()).orElseThrow(()->new ResourceNotFoundEXception("User not found"));
         user1.setName(user.getName());
         user1.setEmail(user.getEmail());
         user1.setPassword(user.getPassword());
         user1.setAbout(user.getAbout());
         user1.setPhoneNumber(user.getPhoneNumber());
         user1.setProfilePic(user.getProfilePic());
         user1.setEnabled(user.isEnabled());
         user1.setEmailVerified(user.isEmailVerified());
         user1.setPhoneVerified(user.isPhoneVerified());
         user1.setProvider(user.getProvider());
         user1.setProviderUserId(user.getProviderUserId());

         //save the user in database
         User save = userRepo.save(user1);
         return Optional.ofNullable(save);
    }

    @Override
    public void deletUser(String userId) {
        User user1 = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundEXception("User not found"));
        userRepo.delete(user1);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user1 = userRepo.findById(userId).orElse(null);
        return user1!=null ? true : false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user1 = userRepo.findByEmail(email).orElse(null);
        return user1!=null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    

}
