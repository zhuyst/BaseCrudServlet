package service;

import dao.ArticleDao;
import dao.StudentDao;
import pojo.BaseEntity;
import pojo.Student;

import java.util.List;

/**
 * 学生实体的服务类
 * @author zhuyst
 */
public class StudentService extends BaseCrudService<StudentDao, Student> {

    /**
     * 论文实体的DAO
     * 主要为 {@link #delete(int)} 服务
     */
    private ArticleDao articleDao;

    /**
     * 单例对象
     */
    private static StudentService instance;

    /**
     * 私有的构造方法
     * 引入 {@link ArticleDao#getInstance()}
     */
    private StudentService() {
        super(StudentDao.getInstance());
        articleDao = ArticleDao.getInstance();
    }

    /**
     * 获取单例对象
     * @return 单例对象
     */
    public static StudentService getInstance(){
        if(instance == null){
            instance = new StudentService();
        }
        return instance;
    }

    /**
     * 使用学生姓名进行模糊查询
     * @param name 查询关键字 - 学生姓名 {@link Student#name}
     * @return 查询到的学生列表
     */
    public List<Student> searchByName(String name){
        return dao.searchByName(name);
    }

    /**
     * 在调用 {@link BaseCrudService#save(BaseEntity)} 方法前做了处理
     * 防止出现学生姓名重复的情况
     * @param student 要保存的学生实体
     * @return 保存后的学生实体
     */
    @Override
    public Student save(Student student) {
        Student queryStudent = this.getByName(student.getName());
        if(queryStudent == null){
            throw new RuntimeException("该学生姓名已存在");
        }
        return super.save(student);
    }

    /**
     * 通过学生姓名查询对应学生 {@link Student#name}
     * @param name 学生姓名
     * @return 学生实体，如果没有查询到则返回NULL
     */
    public Student getByName(String name){
        return dao.selectByName(name);
    }

    /**
     * 在调用 {@link BaseCrudService#delete(int)} 方法后做了处理
     * 删除学生的同时也删除学生发布的论文
     * @param id 要删除的学生的ID
     */
    @Override
    public void delete(int id) {
        super.delete(id);
        articleDao.deleteByStudentId(id);
    }
}
