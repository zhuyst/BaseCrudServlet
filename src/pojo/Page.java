package pojo;

import java.util.List;

/**
 * 包装了分页所需要得信息的泛型类
 * 应配合分页工具使用 {@link util.PageUtils}
 * @param <T> 列表中的对象类型
 * @author zhuyst
 */
public class Page<T> {

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 总条数
     * 可使用 {@link List#size()} 获取total
     */
    private Integer total;

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 总页数
     * 可使用 {@link util.PageUtils#getPages(int, int)} 该方法获取pages
     */
    private Integer pages;

    /**
     * 存储了分页完成后的list对象
     */
    private List<T> list;

    public Page(){}

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
