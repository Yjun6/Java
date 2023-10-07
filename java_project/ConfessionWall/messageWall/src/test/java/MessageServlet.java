import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-06
 * Time:22:22
 */

class Message {
    public String from;
    public String to;
    public String message;
}

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Message> list = new ArrayList<>();
    // 实现“存档功能”
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.读取body数据，转换成java对象
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        //2.得到message之后，把这个message保存到服务器
        list.add(message);
        //3.返回响应
        resp.setStatus(200);
        resp.getWriter().write("OK");
    }
    //实现‘读档’功能
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 把内存的message组织成json返回即可
        String respJson = objectMapper.writeValueAsString(list);
        resp.setContentType("application/json; charset = utf8");
        resp.getWriter().write(respJson);
    }
}
