import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-09-30
 * Time:21:38
 */

class User {
    public String username;
    public String password;
}

@WebServlet("/json")
public class JsonServlet extends HttpServlet {
    // 此处约定客户端body按照json格式来进行传输
    //其中的格式形如：
    // {
    //   user: "sf"
    // }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(req.getInputStream(), User.class);
        System.out.println("username=" + user.username + "password" + user.password);
        resp.getWriter().write("OK");
    }
}
