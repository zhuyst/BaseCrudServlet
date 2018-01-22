package pojo;

/**
 * 对 {@link Article} 进行包装的DTO
 * @author 朱悦星
 */
public class ArticleDTO extends Article {

    /**
     * 发表论文的学生
     */
    private Student student;

    /**
     * 必须使用DO对象对该对象进行实例化
     * @param article DO对象
     */
    public ArticleDTO(Article article){
        this.setId(article.getId());
        this.setTitle(article.getTitle());
        this.setContent(article.getContent());
        this.setStudentId(article.getStudentId());
        this.setPicture(article.getPicture());
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
