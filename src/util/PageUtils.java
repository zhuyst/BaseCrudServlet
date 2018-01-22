package util;

import pojo.Page;

import java.util.List;

/**
 * 分页工具类
 * @author zhuyst
 */
public class PageUtils {

    /**
     * 通过分页所需要的信息，生成分页对象
     * @param pageNum 当前页码
     * @param pageSize 页面的大小
     * @param list 完整的list，将调用 {@link List#subList(int, int)} 分割
     * @param <T> 分页对象中存储的实体类型
     * @return 分页对象
     */
    public static <T> Page<T> getPage(int pageNum, int pageSize, List<T> list){
        Page<T> page = new Page<>();
        page.setPageSize(pageSize);

        int total = list.size();
        page.setTotal(total);

        int pages = getPages(total,pageSize);
        page.setPages(pages);

        if(pageNum < 1){
            pageNum = 1;
        }
        else if(pageNum > pages){
            pageNum = pages;
        }
        page.setPageNum(pageNum);

        int last = pageSize * pageNum;
        if(last > total){
            last = total;
        }

        list = list.subList(pageSize * (pageNum - 1),last);
        page.setList(list);

        return page;
    }

    /**
     * 通过一个分页对象，重新封装为另一个分页对象，一般用于含有继承关系的实体类
     * @param page 原先的分页对象
     * @param list 新的实体对象数组，将被设置到分页对象中
     * @param <T> 新的实体对象的类型
     * @return 包装了新实体的分页对象
     */
    public static <T> Page<T> copyNewPage(Page page,List<T> list){
        Page<T> newPage = new Page<>();

        newPage.setPageNum(page.getPageNum());
        newPage.setPageSize(page.getPageSize());
        newPage.setPages(page.getPages());
        newPage.setTotal(page.getTotal());
        newPage.setList(list);

        return newPage;
    }

    /**
     * 通过总记录数以及页面大小获取总页数
     * @param total 总记录数
     * @param pageSize 页面大小
     * @return 总页数
     */
    public static int getPages(int total,int pageSize){
        return (int) Math.ceil((double) total / pageSize);
    }

}
