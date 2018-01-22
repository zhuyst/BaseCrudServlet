package servlet;

import javax.servlet.http.HttpServlet;

/**
 * 所有Servlet都应继承的基础抽象类
 * @author zhuyst
 */
public abstract class BaseServlet extends HttpServlet{

    /**
     * JSP文件保存的位置
     */
    protected static final String JSP_FILE_PATH = "/WEB-INF/jsps/";

    /**
     * 上传图片保存的位置
     */
    protected static final String IMAGE_FILE_PATH = "/WEB-INF/images/";
}
