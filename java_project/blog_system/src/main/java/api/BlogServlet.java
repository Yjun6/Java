package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Blog;
import dao.BlogDao;
import dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-16
 * Time:22:05
 */
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询数据库，获取到数据之后，构造成要求的json格式返回
        //先尝试获取下blogId,看能不能获取到
        String blogId = req.getParameter("blogId");
        BlogDao blogDao = new BlogDao();
        if (blogId == null) {
            //说明获取博客列表，没有blogId这个参数
            List<Blog> blogs = blogDao.getBlogs();
            String respJson = objectMapper.writeValueAsString(blogs);
            resp.setContentType("application/json; charset=utf8");
            resp.getWriter().write(respJson);
        } else {
            //此时获取博客详情，有blogId参数
            Blog blog = blogDao.getBlog(Integer.parseInt(blogId));
            String respJson = "{}";
            if (blog == null) {
                blog = new Blog();
            }
            respJson = objectMapper.writeValueAsString(blog);
            resp.setContentType("application/json; charset=utf8");
            resp.getWriter().write(respJson);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取到登录的用户的参数
        // 在博客编辑页，已经做了登录检查，当用户提交时，必然是已经登录状态
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户未登录，无法发布博客");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户未登录，无法发布博客");
            return;
        }
        //2.获取请求中的传递的内容
        req.setCharacterEncoding("utf8");//遇到中文处理一下
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (title == null || content == null
                || title.equals("") || content.equals("")) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("标题或正文为空");
            return;
        }
        //3.构造Blog对象，并且插入到数据库中
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUserId(user.getUserId());
        // 由于在sql插入数据时，已经使用now获取当前时间，不需要此时在手动加入时间
        BlogDao blogDao = new BlogDao();
        blogDao.insert(blog);
        //4. 跳转到博客列表页
        resp.sendRedirect("blog_list.html");
    }
}
