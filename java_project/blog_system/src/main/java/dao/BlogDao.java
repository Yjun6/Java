package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:通过这个类，针对 blog 表的增删改查封装
 * Dao Data Access Object
 * User:Yu
 * Date:2023-10-15
 * Time:23:20
 */
public class BlogDao {
    // 1.新增一个博客
    // 通过blog对象对数据库的插入
    public void insert(Blog blog) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.和数据库建立连接
            connection = DBUtil.getConnection();
            //2.构造sql
            String sql = "insert into blog values(null,?,?,?,now())";
            statement = connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getUserId());
            //3.执行sql
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            //4.关闭资源，释放资源
            DBUtil.close(connection, statement, null);
        }
    }

    //2.查询blog的所有博客
    //正常开发中，指定条件查询博客，或者最大条数的博客
    public List<Blog> getBlogs() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Blog> blogs = new ArrayList<>();
        try{
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造sql
            String sql = "select * from blog order by postTime desc;";
            statement = connection.prepareStatement(sql);
            //3.执行sql
            resultSet = statement.executeQuery();
            //4.遍历结果集合
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blogs.add(blog);
            }
            return blogs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            DBUtil.close(connection, statement, resultSet);
        }
        //如果前面查询出现异常，会返回Null的链表
        return blogs;
    }

    //3.指定blogId,查询某一个博客
    public Blog getBlog(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Blog blog = new Blog();
        try {
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造sql
            String sql = "select * from blog where blogId = ?;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            //3.执行sql
            resultSet = statement.executeQuery();
            // 由于此处blogId是主键，要么是一条记录，要么是零条
            if (resultSet.next()) {
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                return blog;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return blog;
    }

    //4.指定博客进行删除
    public void delete(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造sql
            String sql = "delete from blog where blogId = ?;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            //3.执行sql
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    //修改博客...的操作，有待扩展
}














