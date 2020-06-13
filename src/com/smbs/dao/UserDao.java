package com.smbs.dao;

import com.smbs.entity.SuperUsers;

import java.util.List;

public interface UserDao {

    SuperUsers getUserByName(String username);

    SuperUsers getUserById(String userId);

    List<SuperUsers> getAllUsers();

    boolean updateUser(SuperUsers user);

    boolean deleteUserById(String id);

    boolean addUser(SuperUsers user);

    List<SuperUsers> search(String search_name);

}

