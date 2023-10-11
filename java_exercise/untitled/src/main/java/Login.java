import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-11
 * Time:22:13
 */
@WebServlet("/login1")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username == null || password == null || username.equals("") || password.equals("")) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("请求参数有误");
            return;
        }
        //2.验证用户密码是否正确
        if(!username.equals("lisi")) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名错误");
        }
        if(!password.equals("123")) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("密码错误");
        }
        //3.登陆成功
        HttpSession session = req.getSession(true);
        session.setAttribute("username",username);
        session.setAttribute("time",System.currentTimeMillis());
        //4.跳转网页
        resp.sendRedirect("index");
    }
}
