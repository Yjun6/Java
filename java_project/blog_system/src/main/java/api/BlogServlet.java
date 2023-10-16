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
        BlogDao blogDao = new BlogDao();
        List<Blog> blogs = blogDao.getBlogs();
        String respJson = objectMapper.writeValueAsString(blogs);
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(respJson);
    }
}














