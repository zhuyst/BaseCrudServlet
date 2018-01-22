package service;

import dao.ArticleDao;
import pojo.Article;
import pojo.ArticleDTO;
import pojo.Student;

import java.util.List;

/**
 * 论文实体的服务类
 * 提供对论文的增删改查
 * @author 朱悦星
 */
public class ArticleService extends BaseCrudService<ArticleDao, Article> {

    /**
     * 需要学生实体的服务类来拼装 {@link ArticleDTO#student}
     */
    private StudentService studentService;

    /**
     * 单例对象
     */
    private static ArticleService instance;

    /**
     * 私有的构造方法
     * 引入 {@link StudentService#getInstance()}
     */
    private ArticleService() {
        super(ArticleDao.getInstance());
        studentService = StudentService.getInstance();
    }

    /**
     * 获取单例对象
     * @return 单例对象
     */
    public static ArticleService getInstance(){
        if(instance == null){
            instance = new ArticleService();
        }
        return instance;
    }

    /**
     * 通过ID获取论文实体 {@link Article#id}
     * @param id 要获取的论文ID
     * @return 查询到的论文实体，如果没有查询到则返回NULL
     */
    @Override
    public Article get(int id) {
        Article article = super.get(id);
        return this.producePojo(article);
    }

    /**
     * 查询论文列表，并使用 {@link #producePojo(Article)} 进行封装
     * 最新返回的实体类型实际为 {@link ArticleDTO}
     * @return 论文列表
     */
    @Override
    public List<Article> list() {
        List<Article> list = super.list();
        return this.producePojoList(list);
    }

    /**
     * 通过 {@link StudentService#get(int)} 封装发表论文的学生实体，生成DTO
     * @param article 将被重新封装的论文实体类
     * @return 封装后的实体类
     */
    private ArticleDTO producePojo(Article article){
        ArticleDTO pojo = new ArticleDTO(article);

        Student student = studentService.get(article.getStudentId());
        pojo.setStudent(student);

        return pojo;
    }

    /**
     * 通过 {@link #producePojo(Article)} 封装DTO列表
     * @param list 将被封装的列表
     * @return 返回封装完成的列表
     */
    private List<Article> producePojoList(List<Article> list){
        for(int i = 0;i < list.size();i++){
            Article article = list.get(i);
            list.set(i,this.producePojo(article));
        }
        return list;
    }
}
