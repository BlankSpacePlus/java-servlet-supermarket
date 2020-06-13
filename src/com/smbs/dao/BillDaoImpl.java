package com.smbs.dao;

import com.smbs.entity.SuperBills;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao {

    private Connection connection;

    public BillDaoImpl() {
        connection = MySQLConnector.getConnection();
    }

    @Override
    public List<SuperBills> getAllBills() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<SuperBills> list = new ArrayList<>();
        String sql = "select * from superbills";
        SuperBills bill;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                bill = new SuperBills(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getBigDecimal(5), resultSet.getInt(6),
                        resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9));
                list.add(bill);
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败!");
        } finally {
            MySQLConnector.closeConnection(resultSet, statement, connection);
        }
        return list;
    }

    @Override
    public SuperBills getBillById(String id) {
        SuperBills bill = null;
        String sql = "select * from superbills where billid=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bill = new SuperBills(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getBigDecimal(5), resultSet.getInt(6),
                        resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9));
            }
        } catch (SQLException e) {
            System.err.println("建立通道失败");
        } finally {
            MySQLConnector.closeConnection(resultSet, preparedStatement, connection);
        }
        return bill;
    }

    @Override
    public boolean updateBill(SuperBills bill) {
        int count;
        String sql="update superbills set productname=?,productdesc=?,productcount=?,totalprice=?,ispayment=?,providerid=?,creator=?,createtime=? where billid=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bill.getProductName());
            preparedStatement.setString(2, bill.getProductDesc());
            preparedStatement.setInt(3, bill.getProductCount());
            preparedStatement.setBigDecimal(4, bill.getTotalPrice());
            preparedStatement.setInt(5, bill.getIsPayment());
            preparedStatement.setInt(6, bill.getProviderID());
            preparedStatement.setString(7, bill.getCreator());
            preparedStatement.setString(8, bill.getCreateTime());
            preparedStatement.setInt(9, bill.getBillID());
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
    public boolean deleteBill(int id) {
        int count;
        String sql="delete from superbills where billid=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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
    public boolean addBill(SuperBills bill) {
        int count = 0;
        String sql="insert into superbills values(null,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bill.getProductName());
            preparedStatement.setString(2, bill.getProductDesc());
            preparedStatement.setInt(3, bill.getProductCount());
            preparedStatement.setBigDecimal(4, bill.getTotalPrice());
            preparedStatement.setInt(5, bill.getIsPayment());
            preparedStatement.setInt(6, bill.getProviderID());
            preparedStatement.setString(7, bill.getCreator());
            preparedStatement.setString(8, bill.getCreateTime());
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
    public List<SuperBills> search(String search_name, int isPayment) {
        List<SuperBills> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SuperBills provider;
        String sql = "select * from superbills where productname like ? and ispayment=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+search_name+"%");
            preparedStatement.setInt(2, isPayment);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                provider = new SuperBills(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getBigDecimal(5), resultSet.getInt(6),
                        resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9));
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
