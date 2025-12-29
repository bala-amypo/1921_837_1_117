package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    UserAccount getByUsername(String username);

    UserAccount getByEmployeeId(String employeeId);

    List<UserAccount> getAllUsers();

    UserAccount getById(long id);

    UserAccount updateUserStatus(long id, String status);
}
