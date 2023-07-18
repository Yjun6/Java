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
 * Date:2023-07-18
 * Time:20:14
 */
//查询
public class Select {
    public static void main(String[] args) throws SQLException {
        //创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/suxi?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("666666");
        //连接
        Connection connection = dataSource.getConnection();
        //构造
        String sql = "select *from student;";
        PreparedStatement statement = connection.prepareStatement(sql);
        //执行
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id="+id+"\tname="+name);
        }
        //关闭
        resultSet.close();
        statement.close();
        connection.close();
    }
}
