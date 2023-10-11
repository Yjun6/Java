import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-11
 * Time:22:21
 */
//通过他生成跳转网页
    @WebServlet("/index1")
public class Index extends HelloServelt{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //验证用户的登录状态
        HttpSession session = req.getSession(false);
        if(session == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("请先登录，再访问主页");
            return;
        }
        //已经登录
        String username = (String) session.getAttribute("username");
        long time = (long) session.getAttribute("time");
        System.out.println("username:"+username+", time:"+time);
        //根据这样的内容构造页面
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write("欢迎您，"+username+"! 上次登录时间："+time);
    }
}
