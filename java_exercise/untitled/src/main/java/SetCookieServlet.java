import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-10
 * Time:21:26
 */
@WebServlet("/setcookie")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //期望通过这个doGet方法，把一个自定义的cookie数据返回到浏览器这边
        Cookie cookie = new Cookie("date","2023-9-23");
        resp.addCookie(cookie);
        Cookie cookie2 = new Cookie("time","15:17");
        resp.addCookie(cookie2);
        resp.getWriter().write("setCookie OK");
    }
}
