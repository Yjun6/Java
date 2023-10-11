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
 * Time:13:24
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取到用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username == null || password == null
            || username.equals("") || password.equals("")) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("请求的参数不完整");
            return;
        }
        //2.验证用户密码是否正确
        //此处约定合法的用户名： zahngsan， 密码：123
        if(!username.equals("zhangsan")) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名错误");
            return;
        }
        if(!password.equals("123")) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("密码错误");
            return;
        }
        //3.登录成功
        HttpSession session = req.getSession(true);
        // 在会话中保存自定义的数据，比如登录的时间戳
        //setAttribute的第二个参数是Object
        session.setAttribute("username",username);
        session.setAttribute("time",System.currentTimeMillis());
        //4.页面自动跳转到网站页面
        resp.sendRedirect("index");
    }
}
