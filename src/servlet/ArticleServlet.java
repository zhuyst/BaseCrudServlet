package servlet;

import enums.CrudTypeEnum;
import pojo.Article;
import pojo.ArticleDTO;
import pojo.Page;
import pojo.Student;
import service.ArticleService;
import util.PageUtils;
import util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

/**
 * 论文相关的Servlet
 * @author 朱悦星
 */
@MultipartConfig
public class ArticleServlet extends BaseCrudServlet<ArticleService, Article> {

    /**
     * 构造方法，引入 {@link ArticleService#getInstance()}
     */
    public ArticleServlet() {
        super(ArticleService.getInstance());
    }

    /**
     * 在调用 {@link BaseCrudServlet#doGet(HttpServletRequest, HttpServletResponse)} 后做处理
     * 将 {@link Article} 的List对象重新包装为 {@link ArticleDTO} 的List
     * 在做完相应的处理后跳转到页面中
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        CrudTypeEnum typeEnum = (CrudTypeEnum) req.getAttribute(ATTRIBUTE_TYPE);

        if(typeEnum == CrudTypeEnum.LIST){
            Page<Article> page = (Page<Article>) req.getAttribute(ATTRIBUTE_PAGE);

            List<ArticleDTO> pojoList = new ArrayList<>();
            for(Article article : page.getList()){
                pojoList.add((ArticleDTO) article);
            }

            req.setAttribute(ATTRIBUTE_PAGE, PageUtils.copyNewPage(page,pojoList));

            req.getRequestDispatcher(JSP_FILE_PATH + "article-index.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher(JSP_FILE_PATH + "article-edit.jsp").forward(req,resp);
        }
    }

    /**
     * 在调用 {@link BaseCrudServlet#doPost(HttpServletRequest, HttpServletResponse)} 后做处理
     * 在执行操作前，通过 {@link SessionUtils#getStudent(HttpSession)} 获取当前登录的学生
     * 并通过比对ID来管理权限，权限通过才会执行
     * 执行完成后重定向回列表页面
     * @exception AccessDeniedException 没有权限时将抛出该异常
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CrudTypeEnum typeEnum = super.getType(req);

        if(typeEnum != CrudTypeEnum.INSERT){
            Integer id = Integer.valueOf(req.getParameter("id"));
            Article article = service.get(id);

            Student student = SessionUtils.getStudent(req.getSession());

            if(!student.getId().equals(article.getStudentId())){
                throw new AccessDeniedException("您没有权限进行这项操作");
            }
        }

        super.doPost(req, resp);
        resp.sendRedirect(req.getContextPath() + "/article");
    }

    /**
     * 通过request包装论文实体类
     * 在有上传论文封面时会调用 {@link Part#write(String)} 保存图片
     * 并将图片保存路径包装进实体类中
     * @return 包装后的实体类
     */
    @Override
    public Article getPojo(HttpServletRequest req) throws IOException, ServletException {
        Article article = new Article();

        String id = req.getParameter("id");
        if(id != null){
            article.setId(Integer.valueOf(id));
        }

        Student student = SessionUtils.getStudent(req.getSession());
        article.setStudentId(student.getId());

        String title = req.getParameter("title");
        article.setTitle(title);

        String content = req.getParameter("content");
        article.setContent(content);

        Part part = req.getPart("newPicture");
        String fileName = getFileName(part);
        if(fileName != null){
            String savePath = req.getServletContext().getRealPath(IMAGE_FILE_PATH);

            fileName = System.currentTimeMillis() + getFileName(part);
            String filePath = savePath + File.separator + fileName;

            part.write(filePath);
            article.setPicture(fileName);
        }
        else {
            String filePath = req.getParameter("picture");
            article.setPicture(filePath);
        }

        return article;
    }

    /**
     * 通过 {@link Part#getHeader(String)} 获取上传文件名
     * @param part 要获取对应文件名的Part对象
     * @return 上传的文件名
     */
    private String getFileName(Part part) {
        String contentDispositionHeader =
                part.getHeader("content-disposition");
        String[] elements = contentDispositionHeader.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1)
                        .trim().replace("\"", "");
            }
        }
        return null;
    }
}
