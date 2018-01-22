package util;

import pojo.Student;

import javax.servlet.http.HttpSession;

/**
 * 对项目中的 {@link HttpSession} 进行操作的工具类
 * @author zhuyst
 */
public class SessionUtils {

    /**
     * 存储在session中学生的属性名
     */
    public static final String SESSION_ATTRIBUTE_STUDENT = "student";

    /**
     * 往session设置学生，以作为登陆标记 {@link filter.LoginFilter}
     * @param session HttpSession，用于设置对象
     * @param student 要设置的学生对象
     */
    public static void setStudent(HttpSession session, Student student){
        session.setAttribute(SESSION_ATTRIBUTE_STUDENT,student);
    }

    /**
     * 从session获取学生，用于登陆验证 {@link filter.LoginFilter}
     * @param session HttpSession，用于获取对象
     * @return 登陆中的学生对象，如果没有则会返回NULL
     */
    public static Student getStudent(HttpSession session){
        return (Student) session.getAttribute(SESSION_ATTRIBUTE_STUDENT);
    }
}
