package com.smbs.dao;

import java.sql.*;

public class MySQLConnector {

    public static Connection getConnection(){
        String driverName="com.mysql.cj.jdbc.Driver";
        String dbURL="jdbc:mysql://localhost:3306/supermarket?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String userName="root";
        String userPassword="123456";
        try{
            Class.forName(driverName);
        } catch(ClassNotFoundException e) {
            System.err.println("加载MySQL驱动失败");
            e.printStackTrace();
        }
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection(dbURL, userName, userPassword);
        } catch(SQLException e) {
            System.err.println("数据库连接失败");
            e.printStackTrace();
        }
        return dbConnection;
    }

    public static void closeConnection(ResultSet resultSet, Statement statement, Connection dbConnection){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("关闭通道失败");
                e.printStackTrace();
            }
        }
        if(dbConnection!=null){
            try {
                dbConnection.close();
            } catch (SQLException e) {
                System.err.println("关闭数据库连接失败");
                e.printStackTrace();
            }
        }
    }

}
