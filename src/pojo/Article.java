package pojo;

/**
 * 论文实体类
 * @author zhuyst
 */
public class Article extends BaseEntity{

    /**
     * 发表论文的学生的ID {@link Student#id}
     */
    private Integer studentId;

    /**
     * 论文标题
     */
    private String title;

    /**
     * 论文内容
     */
    private String content;

    /**
     * 论文封面
     * 存放的是图片相对路径
     */
    private String picture;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
