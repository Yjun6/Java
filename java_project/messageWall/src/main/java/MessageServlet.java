import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-08
 * Time:10:59
 */

class Message {
    public String from;
    public String to;
    public String message;

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper mapper = new ObjectMapper();
//    private List<Message> messageList = new ArrayList<>();
    //存档
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.读取Body，转成java对象
        Message message = mapper.readValue(req.getInputStream(),Message.class);
        //2.message存储到服务器
//        messageList.add(message);
        try {
            save(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(message);
        //3.返回响应
        resp.setStatus(200);
        resp.getWriter().write("ok");
    }

    //读档
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拿到内存message，转成json，返回
        List<Message> messageList = null;
        System.out.println("读档");
        try {
            messageList = load();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String respJson = mapper.writeValueAsString(messageList);
        System.out.println("读档"+respJson);
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(respJson);
    }

    // 通过jdbc,往数据库存储数据
    private void save(Message message) throws SQLException {
        //1.创建数据库
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("666666");
        //2.建立连接
        Connection connection = dataSource.getConnection();
        //3.构造sql
        String sql = "insert into messageWall values(?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,message.from);
        statement.setString(2,message.to);
        statement.setString(3,message.message);
        //4.执行sql
        statement.executeUpdate();
        //5.释放资源，关闭连接
        statement.close();
        connection.close();
    }

    //通过jdbc,从数据库读取数据
    private List<Message> load() throws SQLException {
        //1.创建数据库
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("666666");
        //2.建立连接
        Connection connection = dataSource.getConnection();
        //3.构造sql
        String sql = "select * from messageWall";
        PreparedStatement statement = connection.prepareStatement(sql);
        //4.执行sql
        ResultSet resultSet = statement.executeQuery();
        //5.遍历结果集合
        List<Message> messageList = new ArrayList<>();
        while (resultSet.next()) {
            Message message = new Message();
            message.from = resultSet.getString("from");
            message.to = resultSet.getString("to");
            message.message = resultSet.getString("message");
            messageList.add(message);
        }
        //6.关闭连接释放资源
        resultSet.close();
        statement.close();
        connection.close();
        return messageList;
    }
}
