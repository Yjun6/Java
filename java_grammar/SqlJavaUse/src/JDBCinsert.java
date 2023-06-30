import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-30
 * Time:15:18
 */
public class JDBCinsert {
    public static void main(String[] args) throws SQLException {
        //1.创建并初始化一个数据源
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setUrl();
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/suxi?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("666666");
        //2.和数据库服务器建立连接
        Connection connection = dataSource.getConnection();
        //3.构造sql语句
        String sql = "insert into stu values(1,'李四')";
        PreparedStatement statement = connection.prepareStatement(sql);
        //4.执行sql语句
        int ret = statement.executeUpdate();
        System.out.println("ret="+ret);
        //5.释放必要的资源
        statement.close();
        connection.close();
    }
}
