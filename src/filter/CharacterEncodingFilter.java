package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 转换编码使用的Filter
 * @author zhuyst
 */
public class CharacterEncodingFilter implements Filter{

    /**
     * 编码的类型
     */
    private static final String ENCODE = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 将request与response均设置为 {@link #ENCODE} 编码
     * @param request 将被设置为 {@link #ENCODE} 的request
     * @param response 将被设置为 {@link #ENCODE} 的response
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(ENCODE);
        response.setCharacterEncoding(ENCODE);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
