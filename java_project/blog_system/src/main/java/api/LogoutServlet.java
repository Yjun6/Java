package api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:注销账户
 * User:Yu
 * Date:2023-10-18
 * Time:22:34
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            //当前已经是未登录状态
            resp.sendRedirect("login.html");
            return ;
        }
        //在登录成功时，有一个增加user的attribute
        //注销时，需要删掉这个记录 删掉后自然就会判定为未登录
        session.removeAttribute("user");
        resp.sendRedirect("login.html");
    }
}
