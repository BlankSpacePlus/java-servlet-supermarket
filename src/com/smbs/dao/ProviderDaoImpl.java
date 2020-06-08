package com.smbs.dao;

import com.smbs.entity.SuperProviders;
import com.smbs.entity.SuperUsers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProviderDaoImpl implements ProviderDao {

    private Connection connection;

    public ProviderDaoImpl() {
        connection = MySQLConnector.getConnection();
    }

    @Override
    public boolean addProvider(SuperProviders superProviders) {
        int count = 0;
        String sql="insert into superproviders values(null,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,superProviders.getProviderName());
            preparedStatement.setString(2,superProviders.getProviderDesc());
            preparedStatement.setString(3,superProviders.getProviderTel());
            preparedStatement.setString(4,superProviders.getProviderAddress());
            preparedStatement.setString(5,superProviders.getCreator());
            preparedStatement.setString(6,superProviders.getCreateTime());
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
    public boolean deleteProviderById(String id) {
        int count = 0;
        String sql="delete from superproviders where providerid=?";
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
    public boolean updateProvider(SuperProviders superProviders) {
        int count;
        String sql="update superproviders set providername=?,providerdesc=?,providertel=?,provideraddress=?,creator=?,createtime=? where providerid=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,superProviders.getProviderName());
            preparedStatement.setString(2,superProviders.getProviderDesc());
            preparedStatement.setString(3,superProviders.getProviderTel());
            preparedStatement.setString(4,superProviders.getProviderAddress());
            preparedStatement.setString(5,superProviders.getCreator());
            preparedStatement.setString(6,superProviders.getCreateTime());
            preparedStatement.setInt(7,superProviders.getProviderID());
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
    public SuperProviders getProviderById(String id) {
        SuperProviders user = null;
        String sql="select * from superproviders where providerid=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new SuperProviders(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7));
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败");
        } finally {
            MySQLConnector.closeConnection(resultSet, preparedStatement, connection);
        }
        return user;
    }

    @Override
    public List<SuperProviders> getAllProviders() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<SuperProviders> list = new ArrayList<>();
        String sql="select * from superproviders";
        SuperProviders user;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user = new SuperProviders(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7));
                list.add(user);
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败!");
        } finally {
            MySQLConnector.closeConnection(resultSet, statement, connection);
        }
        return list;
    }

}

