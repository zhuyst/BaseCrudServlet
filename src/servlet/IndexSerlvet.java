package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 主页的Servlet
 * @author 朱悦星
 */
public class IndexSerlvet extends BaseServlet{

    /**
     * 返回主页界面
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JSP_FILE_PATH + "index.jsp").forward(req,resp);
    }
}
