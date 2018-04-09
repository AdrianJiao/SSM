package com.company.service;

import com.company.bean.User;

public interface UserService {
    boolean addUser(User user);
    User isUserExist(String username);
}
