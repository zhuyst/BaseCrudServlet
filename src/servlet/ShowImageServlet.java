package servlet;

import pojo.Article;
import service.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 显示图片的Servlet，主要用于论文封面 {@link Article#picture} 的展示
 * @author zhuyst
 */
public class ShowImageServlet extends BaseServlet{

    /**
     * 论文服务类
     */
    private ArticleService articleService;

    /**
     * 构造方法，引入 {@link ArticleService#getInstance()}
     */
    @Override
    public void init() throws ServletException {
        super.init();
        articleService = ArticleService.getInstance();
    }

    /**
     * 通过 {@link Article#id} 获取对应的论文封面 {@link Article#picture}
     * 通过 {@link #IMAGE_FILE_PATH} 拼接获取图片文件，读取到response中
     * @param resp 将被改为图片流的response
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        if(sid != null){
            Integer id = Integer.valueOf(sid);
            Article article = articleService.get(id);

            String picture = article.getPicture();
            if(picture != null){
                String savePath = req.getServletContext().getRealPath(IMAGE_FILE_PATH);

                FileInputStream inputStream = new FileInputStream(savePath + File.separator +
                        picture);
                OutputStream outputStream = resp.getOutputStream();
                
                byte[] buff  = new byte[1024];
                int len;
                while(0 <= (len = inputStream.read(buff))){
                    outputStream.write(buff, 0, len);
                }
                inputStream.close();
                outputStream.close();
            }
        }
    }
}
