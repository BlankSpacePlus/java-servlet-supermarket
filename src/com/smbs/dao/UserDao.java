package com.smbs.dao;

import com.smbs.entity.SuperUsers;

public interface UserDao {

    SuperUsers getUserByName(String username);

}

