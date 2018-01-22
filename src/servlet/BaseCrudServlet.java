package servlet;

import enums.CrudTypeEnum;
import pojo.BaseEntity;
import pojo.Page;
import service.BaseCrudService;
import util.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 基础的增删改查的Servlet
 * 通过 {@link #service} 来进行操作
 * 通过 {@link CrudTypeEnum} 判断操作类型
 * @param <T> 操作实体的服务类
 * @param <E> 要操作的实体
 * @author zhuyst
 */
public abstract class BaseCrudServlet
        <T extends BaseCrudService<?,E>,
                E extends BaseEntity>
        extends BaseServlet{

    /**
     * 操作类型的属性名
     * 属性值类型为 {@link CrudTypeEnum}
     */
    public static final String ATTRIBUTE_TYPE = "type";

    /**
     * 分页的属性名
     * 属性值类型为 {@link Page}
     */
    public static final String ATTRIBUTE_PAGE = "page";

    /**
     * 单个对象的属性名
     * 属性值类型为继承了 {@link BaseEntity} 的实体类
     */
    public static final String ATTRIBUTE_ENTITY = "entity";

    /**
     * 从 {@link taglib.PageTag} 生成，设置的页码属性名
     * 用于辅助 {@link PageUtils#getPage(int, int, List)} 生成 {@link Page}
     */
    public static final String ATTRIBUTE_PAGE_NUM = "pageNum";

    /**
     * 页面大小
     */
    protected static final int PAGE_SIZE = 10;

    /**
     * 操作实体的服务类
     */
    protected T service;

    /**
     * 构造方法，引入 {@link #service}
     * @param service 操作实体的服务类
     */
    protected BaseCrudServlet(T service){
        this.service = service;
    }

    /**
     * 预处理，必须重写
     * GET方法主要用于查询类的方法
     * 主要处理 {@link CrudTypeEnum#LIST} {@link CrudTypeEnum#QUERY}
     * 并且在 {@link CrudTypeEnum#UPDATE} 时，返回原有的实体信息
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CrudTypeEnum typeEnum = getType(req);
        req.setAttribute(ATTRIBUTE_TYPE,typeEnum);

        String sid = req.getParameter("id");
        if(sid == null && typeEnum == CrudTypeEnum.LIST){
            setPage(req);
        }
        else if(typeEnum == CrudTypeEnum.QUERY || typeEnum == CrudTypeEnum.UPDATE){
            Integer id = Integer.valueOf(req.getParameter("id"));
            E entity = service.get(id);

            req.setAttribute(ATTRIBUTE_ENTITY,entity);
        }
    }

    /**
     * 预处理，必须重写
     * POST方法主要用于处理操作类方法
     * 处理 {@link CrudTypeEnum#UPDATE} {@link CrudTypeEnum#DELETE} {@link CrudTypeEnum#INSERT}
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CrudTypeEnum typeEnum = this.getType(req);

        if(typeEnum == CrudTypeEnum.INSERT ||
                typeEnum == CrudTypeEnum.UPDATE){
            E entity = this.getPojo(req);
            service.save(entity);
        }
        else if(typeEnum == CrudTypeEnum.DELETE){
            Integer id = Integer.valueOf(req.getParameter("id"));
            service.delete(id);
        }

        req.setAttribute(ATTRIBUTE_TYPE,typeEnum);
    }

    /**
     * 获取完整列表的方法，可以通过重写该方法实现模糊搜索功能
     * @param req 可用于获取request中的属性
     * @return 返回查询到的List
     */
    protected List<E> getList(HttpServletRequest req){
        return service.list();
    }

    /**
     * 分页查询的方法，设置 {@link #ATTRIBUTE_PAGE} 为 {@link Page}
     * @param req 用于获取request中的属性
     */
    protected void setPage(HttpServletRequest req){
        List<E> list = getList(req);
        String pageNumS = req.getParameter(ATTRIBUTE_PAGE_NUM);
        int pageNum;
        if(pageNumS == null){
            pageNum = 1;
        }
        else {
            pageNum = Integer.valueOf(pageNumS);
        }

        Page<E> page = PageUtils.getPage(pageNum,PAGE_SIZE,list);
        req.setAttribute(ATTRIBUTE_PAGE,page);
    }

    /**
     * 通过 {@link #ATTRIBUTE_TYPE} 获取 {@link CrudTypeEnum}
     * @param request 用于获取 {@link #ATTRIBUTE_TYPE} 属性
     * @return 操作类型枚举类
     */
    protected CrudTypeEnum getType(HttpServletRequest request){
        String type = request.getParameter(ATTRIBUTE_TYPE);
        return CrudTypeEnum.getByValue(type);
    }

    /**
     * 从request中获取属性并且包装为实体类
     * @param req 用于获取request中的属性
     * @return 包装完成的实体类
     * @throws IOException IO异常
     * @throws ServletException Servlet异常
     */
    public abstract E getPojo(HttpServletRequest req) throws IOException, ServletException;
}
