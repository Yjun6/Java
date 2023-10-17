package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Blog;
import dao.BlogDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}














