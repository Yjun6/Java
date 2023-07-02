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
 * Date:2023-07-02
 * Time:21:02
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        //1.创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/suxi?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("666666");
        //2.连接服务器
        Connection connection = dataSource.getConnection();
        //3.构造sql
        String sql = "select *from stu";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //4.执行sql
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id="+id+"name="+name);
        }
        //5.释放资源
         resultSet.close();
        preparedStatement.close();
        connection.close();

    }

    public static void main1(String[] args) throws SQLException {
        //1.创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/suxi?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("666666");
        //2.连接服务器
        Connection connection = dataSource.getConnection();
        //3.构造sql
        String sql = "insert into stu values(?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,1);
        preparedStatement.setString(2,"李四");
        //4.执行sql
        preparedStatement.executeUpdate();
        //5.释放资源
        preparedStatement.close();
        connection.close();

    }
}
