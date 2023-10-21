package com.insta.instagramapi.service;

import com.insta.instagramapi.Exceptions.UserException;
import com.insta.instagramapi.model.User;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public interface UserService {
    public User registerUser(User user) throws UserException;
    public User findUserById(Integer id) throws UserException;
    public User findUserProfile(String token) throws UserException;
    public User findUserByUserName(String userName) throws UserException;
    public String followUser(Integer reqUserId, Integer followUserId) throws UserException;
    public String UnFollowUser(Integer reqUserId, Integer followUserId) throws UserException;
    public List<User> findUserByIds(List<Integer> userIds) throws UserException;
    public List<User> searchUser(String query) throws UserException;
    public User updateUserDetails(User updatedUser,User existinhUser) throws UserException;

}
