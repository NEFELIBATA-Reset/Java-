package dao;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
查看数据库和表的编码集show create database/table tangshi\G
CREATE DATABASE tangshi_server CHARSET utf8mb4;
CREATE TABLE tangshi(
id INT PRIMARY KEY AUTO_INCREMENT,
sha256 CHAR(64) NOT NULL UNIQUE,
dynasty VARCHAR(10) NOT NULL,
title VARCHAR(100) NOT NULL,
author VARCHAR(20) NOT NULL,
content TEXT NOT NULL,
words TEXT NOT NULL
)CHARSET utf8mb4;
*/
public class DBUtils {
    public static MysqlConnectionPoolDataSource getDataSource() {
        //通过DataSource获取Connection
        //创建了一个数据库连接池
        MysqlConnectionPoolDataSource dataSource=new MysqlConnectionPoolDataSource();
        //不带连接池的
        //DataSource dataSource1=new MysqlDataSource();
        dataSource.setServerName("127.0.0.1");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("000000zxcvbnm");
        dataSource.setDatabaseName("tangshi_server");
        dataSource.setUseSSL(false);
        dataSource.setCharacterEncoding("UTF-8");
        return dataSource;
    }
    public static void close(Connection connection,PreparedStatement statement){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
