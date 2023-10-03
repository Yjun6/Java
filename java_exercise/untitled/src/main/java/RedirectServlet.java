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
 * Date:2023-10-03
 * Time:19:31
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //让页面重定向到搜狗主页
//        resp.setStatus(302);
        //使用location属性得知重定向到哪里
//        resp.setHeader("Location","https://www.sogou.com");
        resp.sendRedirect("https://www.sogou.com");
    }
}
