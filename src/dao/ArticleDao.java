package dao;

import pojo.Article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 论文表的数据库操作类
 * @author zhuyst
 */
public class ArticleDao extends BaseDao<Article>{

    /**
     * 表名
     */
    private static final String TABLE_NAME = "T_Student_Article";

    /**
     * 单例对象
     * 通过 {@link #getInstance()} 获取
     */
    private static ArticleDao instance;

    /**
     * 私有的构造方法
     */
    private ArticleDao(){}

    /**
     * 单例方法
     * @return 单例
     */
    public static ArticleDao getInstance(){
        if (instance == null) {
            instance = new ArticleDao();
        }
        return instance;
    }

    /**
     *
     * 通过ID获取论文 {@link Article#id}
     * @param id 要查询的记录的ID
     * @return 论文实体，如果没有查询到则返回NULL
     */
    @Override
    public Article selectById(int id) {
        final String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
        return super.selectById(sql,id);
    }

    /**
     * 列出全部的论文
     * @return 论文实体列表
     */
    @Override
    public List<Article> list() {
        final String sql = "SELECT * FROM " + TABLE_NAME;
        return super.list(sql);
    }

    /**
     * 新增论文
     * @param article 要新增的论文实体
     * @return 自增的主键ID
     */
    @Override
    public Integer insert(Article article) {
        final String sql = "INSERT INTO " + TABLE_NAME + " (student_id,title,content,picture) values(?,?,?,?)";
        return super.insert(sql,article);
    }

    /**
     * 更新论文
     * @param article 要更新的论文实体
     */
    @Override
    public void update(Article article) {
        final String sql = "UPDATE " + TABLE_NAME + " SET student_id=?,title=?,content=?,picture=? WHERE id=?";
        super.update(sql,article,5);
    }

    /**
     * 通过ID删除论文
     * @param id 要删除的记录的ID
     */
    @Override
    public void delete(int id) {
        final String sql = "DELETE FROM " + TABLE_NAME + " WHERE id=?";
        super.delete(sql,id);
    }

    /**
     * 通过学生ID批量删除论文
     * @param studentId 学生的ID
     */
    public void deleteByStudentId(int studentId){
        final String sql = "DELETE FROM " + TABLE_NAME + " WHERE student_id=?";
        super.delete(sql,studentId);
    }

    /**
     * 通过ResultSet获取并包装论文实体类
     * 注意在调用前要使用 {@link ResultSet#next()}
     *
     * @param set 注意游标处于有数据的位置
     * @return 包装后的论文实体类
     * @throws SQLException 数据库异常
     */
    @Override
    protected Article getPojo(ResultSet set) throws SQLException {
        Article article = new Article();

        article.setId(set.getInt("id"));
        article.setStudentId(set.getInt("student_id"));
        article.setTitle(set.getString("title"));
        article.setContent(set.getString("content"));
        article.setPicture(set.getString("picture"));

        return article;
    }

    /**
     * 往PreparedStatement中设置预编译的属性
     * @param preparedStatement 通过SQL实例化后的PreparedStatement
     *                          {@link #prepareStatement(String)},
     *                          {@link #prepareStatement(String, int)}
     * @param article 要往PreparedStatement设置的论文实体
     * @throws SQLException 数据库异常
     */
    @Override
    protected void setPojo(PreparedStatement preparedStatement, Article article) throws SQLException {
        preparedStatement.setInt(1,article.getStudentId());
        preparedStatement.setString(2,article.getTitle());
        preparedStatement.setString(3,article.getContent());
        preparedStatement.setString(4,article.getPicture());
    }
}
