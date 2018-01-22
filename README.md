# BaseCrudServlet
通过泛型 + 枚举，构造了一套以 `资源` 为单位的CRUD Servlet

# 核心类

## BaseEntity
* 所有实体类都应继承的抽象类
* 包含了所有表共有的属性
* 方便 `BaseDao` 对数据库进行操作
```java
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
```

## BaseDao
* 基础的抽象数据库操作类
* 封装了基础的CRUD方法
* `<T>` 要操作的实体类，实体类需要继承 `BaseEntity` ，方便使用主键进行操作
```java
public abstract class BaseDao<T extends BaseEntity> {
    
}
```

## BaseCrudService
* 基础的增删改查的抽象服务类
* 通过 `dao` 来进行数据库操作
* `<D>` 操作对应实体的DAO
* `<E>` 要服务的实体类
```java
public abstract class BaseCrudService<D extends BaseDao<E>,E extends BaseEntity>{
    
}
```

## BaseCrudServlet
* 基础的增删改查的Servlet
* 通过 {@link #service} 来进行操作
* 通过 {@link CrudTypeEnum} 判断操作类型
* @param <T> 操作实体的服务类
* @param <E> 要操作的实体
```java
public abstract class BaseCrudServlet
        <T extends BaseCrudService<?,E>,
                E extends BaseEntity>
        extends BaseServlet{
    
}
```

## CrudTypeEnum
* 增删改查的枚举类
* 配合 `BaseCrudServlet` 使用
```java
public enum CrudTypeEnum {

    /**
     * 查询 - 查询多条记录
     */
    LIST("列表","list"),

    /**
     * 查询 - 查询一条记录
     */
    QUERY("查询","query"),

    /**
     * 新增 - 新增一条记录
     */
    INSERT("新增","insert"),

    /**
     * 更新 - 更新一条记录
     */
    UPDATE("更新","update"),

    /**
     * 删除 - 删除一条记录
     */
    DELETE("删除","delete");

    /**
     * 方法中文名
     */
    private String name;

    /**
     * 在GET方法中，拼接在QueryString上参数值
     */
    private String value;

    CrudTypeEnum(String name,String value){
        this.name = name;
        this.value = value;
    }
}
```