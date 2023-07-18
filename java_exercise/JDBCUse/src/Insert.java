import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-18
 * Time:20:13
 */

//插入
public class Insert {
    public static void main(String[] args) throws SQLException {
        //数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/suxi?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("666666");
        //连接服务器
        Connection connection = dataSource.getConnection();
        //构造sql
        String sql = "insert into student values(1,'李四')";
        PreparedStatement statement = connection.prepareStatement(sql);
        //执行sql
        boolean ret = statement.execute();
        System.out.println(ret);
        //关闭
        statement.close();
        connection.close();

    }
}
