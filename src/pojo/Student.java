package pojo;

/**
 * 学生实体类
 * @author 朱悦星
 */
public class Student extends BaseEntity{

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生所在学校
     */
    private String school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
