package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Blog;
import dao.BlogDao;
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
 * Date:2023-10-18
 * Time:0:39
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogId = req.getParameter("blogId");
        if (blogId == null) {
            //博客列表页面
            //从 session拿到user对象
            HttpSession session = req.getSession(false);
            if (session == null) {
                User user = new User();
                String respJson = objectMapper.writeValueAsString(user);
                resp.setContentType("application/json; charset=utf8");
                resp.getWriter().write(respJson);
                return ;
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                user = new User();
                String respJson = objectMapper.writeValueAsString(user);
                resp.setContentType("application/json; charset=utf8");
                resp.getWriter().write(respJson);
                return;
            }
            String respJson = objectMapper.writeValueAsString(user);
            resp.setContentType("application/json; charset=utf8");
            resp.getWriter().write(respJson);
        } else {
            //博客详情页
            //需要查询数据库
            BlogDao blogDao = new BlogDao();
            Blog blog = blogDao.getBlog(Integer.parseInt(blogId));
            if (blog == null) {
                User user = new User();
                String respJson = objectMapper.writeValueAsString(user);
                resp.setContentType("application/json; charset=utf8");
                resp.getWriter().write(respJson);
                return ;
            }
            UserDao userDao = new UserDao();
            User user = userDao.getUserById(blog.getBlogId());
            if (user == null) {
                user = new User();
                String respJson = objectMapper.writeValueAsString(user);
                resp.setContentType("application/json; charset=utf8");
                resp.getWriter().write(respJson);
                return ;
            }
            String respJson = objectMapper.writeValueAsString(user);
            resp.setContentType("application/json; charset=utf8");
            resp.getWriter().write(respJson);
        }
    }
}
