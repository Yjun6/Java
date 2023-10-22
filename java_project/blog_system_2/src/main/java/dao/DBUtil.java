package dao;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-15
 * Time:21:35
 */

//通过这个类，把数据库建立连接的逻辑进行封装
public class DBUtil {
    //使用单例模式中的懒汉模式进行编写
    private static volatile DataSource dataSource = null;

    private static DataSource getDataSource() {
        if(dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/Java_blog_system?useSSL=false&characterEncoding=utf8");
                    ((MysqlDataSource) dataSource).setUser("root");
//                    ((MysqlDataSource) dataSource).setPassword("666666");
                    //确保密码匹配
                    ((MysqlDataSource) dataSource).setPassword("203105");
                }
            }
        }
        return dataSource;
    }

    //提供一个方法，和数据库建立连接
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过一个方法，和数据库断开连接
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



