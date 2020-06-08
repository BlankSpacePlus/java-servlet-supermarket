package com.smbs.dao;

import java.sql.*;
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

}

