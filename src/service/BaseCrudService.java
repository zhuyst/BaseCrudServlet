package service;

import dao.BaseDao;
import pojo.BaseEntity;

import java.util.List;

/**
 * 基础的增删改查的抽象服务类
 * 通过 {@link #dao} 来进行数据库操作
 * @param <D> 操作对应实体的DAO
 * @param <E> 要服务的实体类
 * @author 朱悦星
 */
public abstract class BaseCrudService<D extends BaseDao<E>,E extends BaseEntity> {

    /**
     * 泛型的DAO，通过构造方法进行初始化
     */
    protected D dao;

    /**
     * 使用DAO初始化服务类
     * @param dao 操作对应实体的DAO
     */
    protected BaseCrudService(D dao){
        this.dao = dao;
    }

    /**
     * 通过ID获取相应实体
     * @param id 要获取的实体ID
     * @return 获取到的实体，如果没有相应的实体则返回NULL
     */
    public E get(int id){
        return dao.selectById(id);
    }

    /**
     * 列出全部的实体
     * @return 获取到的实体列表
     */
    public List<E> list(){
        return dao.list();
    }

    /**
     * 保存某个实体，合并了新增以及更新方法
     * 通过判断 {@link BaseEntity#id} 是否为NULL来判断是新增还是更新
     * @param e 保存的实体类
     * @return 保存后的实体类
     */
    public E save(E e){
        Integer id;

        if(e.getId() == null){
            id = dao.insert(e);
        }
        else {
            id = e.getId();
            dao.update(e);
        }

        return this.get(id);
    }

    /**
     * 删除数据库中的一条数据
     * @param id 要删除的实体的ID
     */
    public void delete(int id){
        dao.delete(id);
    }
}
