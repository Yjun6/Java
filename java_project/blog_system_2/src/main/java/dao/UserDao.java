package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:通过这个类，对 user 表的增删改查封装
 * User:Yu
 * Date:2023-10-15
 * Time:23:20
 */
public class UserDao {
    // 对于新增user,主要是实现一个 注册 功能，有待扩展
    // 对于删除user,主要是实现一个 注销 功能，有待扩展

    //1.根据 userId 查询用户信息(后续根据博客查询作者详情
    public User getUserById(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造sql
            String sql = "select * from user where userId = ?;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            //3.执行sql
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    // 2.根据username 查询用户信息(实现登录效果
    public User getUserByUsername(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造sql
            String sql = "select * from user where username = ?;";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            //3.执行sql
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }
}
