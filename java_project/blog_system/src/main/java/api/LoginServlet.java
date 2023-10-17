package api;

import dao.User;
import dao.UserDao;

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
 * Date:2023-10-17
 * Time:22:36
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求中的用户名和密码
        // 给请求对象设立字符集，保证username password 是中文也能正确处理
        req.setCharacterEncoding("utf8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || password == null
                || username.equals("") || password.equals("")) {
            //当前提交的用户名和密码错误
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前用户名和密码有误");
            return ;
        }

        //2.和数据库交互，验证用户名和密码是否正确
        UserDao userDao = new UserDao();
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            //用户名不存在
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("您的用户名或密码错误！");
            return;
        }
        if (!password.equals(user.getPassword())) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("您的用户名或密码错误！");
            return;
        }

        // 3.创建会话
        // true 存在就查询 不存在就创建 <sessionId,HttpSession>
        HttpSession session = req.getSession(true);
        // 把当前登录信息保存到 session 中,方便后续进行获取
        session.setAttribute("user", user);
        //4. 跳转到博客列表页面
        resp.sendRedirect("blog_list.html");
    }
}
