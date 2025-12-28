package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    UserAccount create(UserAccount user);

    UserAccount getById(long id);

    List<UserAccount> getAllUsers();

    UserAccount updateUserStatus(long id, String status);
}
