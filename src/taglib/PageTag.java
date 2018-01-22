package taglib;

import pojo.Page;
import servlet.BaseCrudServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * 分页页码标签
 * @author 朱悦星
 */
public class PageTag extends TagSupport {

    /**
     * 页码的属性名
     */
    private static final String ATTRIBUTE_PAGE_NUM = BaseCrudServlet.ATTRIBUTE_PAGE_NUM;

    /**
     * 当前页面的URL
     */
    private String url;

    /**
     * 分页对象
     */
    private Page page;

    /**
     * 通过 {@link #page} 进行分页页码的生成
     * 并且通过 {@link HttpServletRequest#getQueryString()} 方法支持模糊查询时的URL
     */
    @Override
    public int doEndTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String queryString = request.getQueryString();
        if(queryString != null && queryString.contains(ATTRIBUTE_PAGE_NUM)
                && queryString.contains("&")){
            queryString = queryString.split("&")[1];
        }

        JspWriter writer = pageContext.getOut();
        StringBuilder sb = new StringBuilder();

        sb.append("<div class='pager'>");
        for(int i = 1;i <= page.getPages();i++){
            if(i == page.getPageNum()){
                sb.append("<span class='page'>").append(i).append("</span>");
            }
            else {
                sb.append("<a class='page' href='").append(url).append("?")
                        .append(ATTRIBUTE_PAGE_NUM).append("=").append(i).append("&")
                        .append(queryString).append("'>").append(i).append("</a>");
            }
        }
        sb.append("<p>").append("当前在第").append(page.getPageNum()).
                append("页，共").append(page.getPages()).append("页").append("</p>");
        sb.append("</div>");

        try {
            writer.print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
