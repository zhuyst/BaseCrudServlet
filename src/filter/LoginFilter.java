package filter;

import pojo.Student;
import util.SessionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆权限拦截使用的Filter，必须登陆才能进入到内部界面
 * @author zhuyst
 */
public class LoginFilter implements Filter{

    /**
     * 登陆的URL
     */
    private static final String LOGIN_URL = "login";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 登陆权限拦截，通过检查Session
     * 将拦截除了 {@link #LOGIN_URL} 以外的所有URL
     * 将登陆除外的URL重定向到 {@link #LOGIN_URL}
     * @param servletRequest 用于获取HttpSession中的学生对象
     *                       {@link SessionUtils#getStudent(HttpSession)}
     * @param servletResponse 如果没有将被重定向到 {@link #LOGIN_URL}
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(!request.getRequestURI().contains(LOGIN_URL)){
            HttpSession session = request.getSession();
            Student student = SessionUtils.getStudent(session);

            if(student == null){
                response.sendRedirect(request.getContextPath() + "/" + LOGIN_URL);
            }
        }

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
