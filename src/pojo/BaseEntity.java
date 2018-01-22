package pojo;

import java.io.Serializable;

/**
 * 所有实体类都应继承的抽象类
 * 包含了所有表共有的属性
 * 方便{@link dao.BaseDao } 对数据库进行操作
 * @author zhuyst
 */
public abstract class BaseEntity implements Serializable{

    private static final long serialVersionUID = -8863046073826611246L;

    /**
     * 自增主键
     * 方便 {@link dao.BaseDao#insert(String, BaseEntity) } 进行新增操作
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
