package enums;

/**
 * 增删改查的枚举类
 * 配合 {@link servlet.BaseCrudServlet} 使用
 * @author 朱悦星
 */
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

    /**
     * 通过value获取对应的枚举实例类
     * @param value 该枚举类的value值
     * @return 对应的枚举实例类，如果没找到则返回 {@link #LIST}
     */
    public static CrudTypeEnum getByValue(String value){
        if(value == null){
            return LIST;
        }

        switch (value){
            case "list":
                return LIST;
            case "query":
                return QUERY;
            case "insert":
                return INSERT;
            case "update":
                return UPDATE;
            case "delete":
                return DELETE;
            default:
                return LIST;
        }
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
