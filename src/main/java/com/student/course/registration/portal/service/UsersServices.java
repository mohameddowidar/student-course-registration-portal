package com.student.course.registration.portal.service;

import com.student.course.registration.portal.dao.UserDao;
import com.student.course.registration.portal.dto.UserDto;

import java.util.List;

public class UsersServices {
    private UserDao userDao = new UserDao();
    public void addUser(UserDto userDto){
        userDao.addUserDTO(userDto);
    }
    public List<UserDto> getAllUsers(){
        return userDao.getAllUser();
    }
    public UserDto getUserByEmail(String email){
        return userDao.getUserByEmail(email);
    }
    public boolean isUserExists(UserDto userDto) {
        return  userDao.isUserExists(userDto);
    }
    public Integer getStudentsNumber(){
       return userDao.getStudentsNumber();
    }
    public Integer getUsersNumber(){
        return userDao.getUsersNumber();
    }
}
