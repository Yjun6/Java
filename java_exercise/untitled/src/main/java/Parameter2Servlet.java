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
 * Date:2023-10-01
 * Time:21:11
 */
@WebServlet("/parameter2")
public class Parameter2Servlet extends HttpServlet {
    // 预期让客户发送一个post请求,同时使用form表单格式在body中传递数据
    // body形如:username=zhangsan&password=123
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        resp.getWriter().write("OK");
    }
}









