package servlet;

import enums.CrudTypeEnum;
import pojo.Student;
import service.StudentService;
import util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 学生相关的Servlet
 * @author zhuyst
 */
public class StudentServlet extends BaseCrudServlet<StudentService,Student> {

    /**
     * 构造方法，引入 {@link StudentService#getInstance()}
     */
    public StudentServlet() {
        super(StudentService.getInstance());
    }

    /**
     * 在调用 {@link BaseCrudServlet#doGet(HttpServletRequest, HttpServletResponse)} 后做处理
     * 跳往相应的界面
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        CrudTypeEnum typeEnum = (CrudTypeEnum) req.getAttribute(ATTRIBUTE_TYPE);

        if(typeEnum == CrudTypeEnum.LIST){
            req.getRequestDispatcher(JSP_FILE_PATH + "student-index.jsp").forward(req,resp);
        }
        else{
            req.getRequestDispatcher(JSP_FILE_PATH + "student-edit.jsp").forward(req,resp);
        }
    }

    /**
     * 在调用 {@link BaseCrudServlet#doPost(HttpServletRequest, HttpServletResponse)} 后做处理
     * 执行完后重定向回列表界面
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        resp.sendRedirect(req.getContextPath() + "/student");
    }

    /**
     * 重写 {@link BaseCrudServlet#getList(HttpServletRequest)} 方法
     * 在request中含有name时，判断使用模糊查询
     * 调用 {@link StudentService#searchByName(String)} 进行模糊搜索
     * @return 如果有name属性，则返回模糊查询后的列表，否则是正常查询
     */
    @Override
    protected List<Student> getList(HttpServletRequest req) {
        String name = req.getParameter("name");

        if(StringUtils.trimToNull(name) != null){
            return service.searchByName(name);
        }

        return super.getList(req);
    }

    /**
     * 通过request包装学生实体类
     * @return 包装后的学生实体类
     */
    @Override
    public Student getPojo(HttpServletRequest req) {
        Student student = new Student();

        String id = req.getParameter("id");
        if(id != null){
            student.setId(Integer.valueOf(id));
        }

        String name = req.getParameter("name");
        student.setName(name);

        String school = req.getParameter("school");
        student.setSchool(school);

        return student;
    }
}
