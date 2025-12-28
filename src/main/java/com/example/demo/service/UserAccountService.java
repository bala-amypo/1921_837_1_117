package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount create(UserAccount user);

    UserAccount getByUsername(String username);

    UserAccount updateUserStatus(long id, String status);
}
