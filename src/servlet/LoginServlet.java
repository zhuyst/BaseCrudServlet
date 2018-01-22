package servlet;

import pojo.Student;
import service.StudentService;
import util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆的Servlet
 * @author zhuyst
 */
public class LoginServlet extends BaseServlet{

    /**
     * 学生服务类
     */
    private StudentService studentService;

    /**
     * 构造方法，引入 {@link StudentService#getInstance()}
     */
    @Override
    public void init() throws ServletException {
        super.init();
        studentService = StudentService.getInstance();
    }

    /**
     * 返回登陆界面
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JSP_FILE_PATH + "login.jsp").forward(req,resp);
    }

    /**
     * 执行登陆操作
     * 通过 {@link StudentService#getByName(String)} 获取学生姓名对应的学生
     * 成功则跳往主页 {@link IndexSerlvet#doGet(HttpServletRequest, HttpServletResponse)}
     * 失败则会设置错误信息，跳回登陆界面 {@link #doGet(HttpServletRequest, HttpServletResponse)}
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Student student = studentService.getByName(name);

        if(student != null){
            HttpSession session = req.getSession();
            SessionUtils.setStudent(session,student);

            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        req.setAttribute("error","该学生不存在，请换个姓名试试");
        req.getRequestDispatcher(JSP_FILE_PATH + "login.jsp").forward(req,resp);
    }
}
