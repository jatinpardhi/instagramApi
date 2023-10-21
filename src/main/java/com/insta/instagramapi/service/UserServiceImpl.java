package com.insta.instagramapi.service;

import com.insta.instagramapi.Exceptions.UserException;
import com.insta.instagramapi.model.User;
import com.insta.instagramapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User registerUser(User user) throws UserException {
        
        return null;
    }

    @Override
    public User findUserById(Integer id) throws UserException {
        return null;
    }

    @Override
    public User findUserProfile(String token) throws UserException {
        return null;
    }

    @Override
    public User findUserByUserName(String userName) throws UserException {
        return null;
    }

    @Override
    public String followUser(Integer reqUserId, Integer followUserId) throws UserException {
        return null;
    }

    @Override
    public String UnFollowUser(Integer reqUserId, Integer followUserId) throws UserException {
        return null;
    }

    @Override
    public List<User> findUserByIds(List<Integer> userIds) throws UserException {
        return null;
    }

    @Override
    public List<User> searchUser(String query) throws UserException {
        return null;
    }

    @Override
    public User updateUserDetails(User updatedUser, User existinhUser) throws UserException {
        return null;
    }
}
