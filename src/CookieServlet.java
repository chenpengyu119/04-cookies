import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie学习：
 *   作用：解决发送的不同请求数据共享问题
 */
@WebServlet(name = "CookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        //设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        //获取请求数据
        //处理请求数据
        //响应处理结果
            //直接响应
            resp.getWriter().write("cookie study");
            //请求转发
            //重定向
    }
}
