package com.smbs.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.smbs.entity.SuperUsers;

public class UserDaoImpl implements UserDao {

    private Connection connection;

    public UserDaoImpl() {
        connection = MySQLConnector.getConnection();
    }

    @Override
    public SuperUsers getUserByName(String username) {
        SuperUsers user = null;
        String sql = "select * from superusers where username=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new SuperUsers(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6),
                        resultSet.getInt(7));
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败");
        } finally {
            MySQLConnector.closeConnection(resultSet, preparedStatement, connection);
        }
        return user;
    }

    @Override
    public SuperUsers getUserById(String userId) {
        SuperUsers user = null;
        String sql = "select * from superusers where userid=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new SuperUsers(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6),
                        resultSet.getInt(7));
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败");
        } finally {
            MySQLConnector.closeConnection(resultSet, preparedStatement, connection);
        }
        return user;
    }

    @Override
    public List<SuperUsers> getAllUsers() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<SuperUsers> list = new ArrayList<>();
        String sql = "select * from superusers";
        SuperUsers user;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user = new SuperUsers(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6),
                        resultSet.getInt(7));
                list.add(user);
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败!");
        } finally {
            MySQLConnector.closeConnection(resultSet, statement, connection);
        }
        return list;
    }

    @Override
    public boolean updateUser(SuperUsers user) {
        int count;
        String sql="update superusers set username=?,password=?,phone=?,address=?,ubirthday=?,role=? where userid=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassWord());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setDate(5, new java.sql.Date(user.getBirthday().getTime()));
            preparedStatement.setInt(6, user.getRole());
            preparedStatement.setString(7, user.getUserID());
            count = preparedStatement.executeUpdate();
            if (count >= 1) {
                System.out.println("修改用户成功!");
            } else {
                System.err.println("没有修改任何用户!");
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败");
        } finally {
            MySQLConnector.closeConnection(null, preparedStatement, connection);
        }
        return true;
    }

    @Override
    public boolean deleteUserById(String id) {
        int count = 0;
        String sql="delete from superusers where userid=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            count = preparedStatement.executeUpdate();
            if (count >= 1) {
                System.out.println("删除用户成功!");
            } else {
                System.err.println("没有删除任何用户!");
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败");
        } finally {
            MySQLConnector.closeConnection(null, preparedStatement, connection);
        }
        return true;
    }

    @Override
    public boolean addUser(SuperUsers user) {
        int count = 0;
        String sql="insert into superusers values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserID());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassWord());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setDate(6, new java.sql.Date(user.getBirthday().getTime()));
            preparedStatement.setInt(7, user.getRole());
            count = preparedStatement.executeUpdate();
            if (count >= 1) {
                return true;
            } else {
                System.err.println("没有添加任何用户!");
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败");
        } finally {
            MySQLConnector.closeConnection(null, preparedStatement, connection);
        }
        return true;
    }

    @Override
    public List<SuperUsers> search(String search_name) {
        List<SuperUsers> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SuperUsers provider;
        String sql = "select * from superusers where username like ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+search_name+"%");
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                provider = new SuperUsers(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6),
                        resultSet.getInt(7));
                list.add(provider);
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败!");
        } finally {
            MySQLConnector.closeConnection(resultSet, preparedStatement, connection);
        }
        return list;
    }

}

