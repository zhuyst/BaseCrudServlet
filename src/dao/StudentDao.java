package dao;

import pojo.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生表的数据库操作类
 */
public class StudentDao extends BaseDao<Student> {

    /**
     * 表名
     */
    private static final String TABLE_NAME = "T_Student";

    /**
     * 单例对象
     * 通过 {@link #getInstance()} 获取
     */
    private static StudentDao instance;

    /**
     * 私有的构造方法
     */
    private StudentDao(){}

    /**
     * 单例方法
     * @return 单例
     */
    public static StudentDao getInstance(){
        if(instance == null){
            instance = new StudentDao();
        }
        return instance;
    }

    /**
     * 通过ID查询学生 {@link Student#id}
     * @param id 要查询的记录的ID
     * @return 学生实体类，如果查询不到则返回NULL
     */
    @Override
    public Student selectById(int id){
        final String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
        return super.selectById(sql,id);
    }

    /**
     * 通过学生姓名查询对应学生 {@link Student#name}
     * @param name 学生姓名
     * @return 学生实体，如果没有查询到则返回NULL
     */
    public Student selectByName(String name){
        final String sql = "SELECT * FROM " + TABLE_NAME + " WHERE name=?";

        try {
            PreparedStatement preparedStatement = super.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet set = preparedStatement.executeQuery();

            set.next();
            return getPojo(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 使用学生姓名进行模糊查询
     * @param name 查询关键字 - 学生姓名 {@link Student#name}
     * @return 查询到的学生列表
     */
    public List<Student> searchByName(String name){
        final String sql = "SELECT * FROM " + TABLE_NAME +
                " WHERE name LIKE CONCAT('%',?,'%')";
        List<Student> list = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = super.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                Student student = getPojo(set);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    /**
     * 查询全部学生
     * @return 学生列表
     */
    @Override
    public List<Student> list(){
        final String sql = "SELECT * FROM " + TABLE_NAME;
        return super.list(sql);
    }

    /**
     * 新增学生
     * @param student 要新增的学生实体
     * @return 新增学生后返回的自增主键
     */
    @Override
    public Integer insert(Student student){
        final String sql = "INSERT INTO " + TABLE_NAME + " (name,school) values (?,?)";
        return super.insert(sql,student);
    }

    /**
     * 更新学生信息
     * @param student 更新的学生实体
     */
    @Override
    public void update(Student student){
        final String sql = "UPDATE " + TABLE_NAME + " SET name=?,school=? WHERE id=?";
        super.update(sql,student,3);
    }

    /**
     * 通过ID删除一名学生
     * @param id 要删除的学生的ID
     */
    @Override
    public void delete(int id){
        final String sql = "DELETE FROM " + TABLE_NAME + " WHERE id=?";
        super.delete(sql,id);
    }

    /**
     * 获取并包装学生实体
     * @param set 注意游标处于有数据的位置
     * @return 包装完成的学生实体
     * @throws SQLException 数据库异常
     */
    @Override
    protected Student getPojo(ResultSet set) throws SQLException{
        Student student = new Student();

        student.setId(set.getInt("id"));
        student.setName(set.getString("name"));
        student.setSchool(set.getString("school"));

        return student;
    }

    /**
     * 往PreparedStatement中设置预编译的属性
     * @param preparedStatement 通过SQL实例化后的PreparedStatement
     *                          {@link #prepareStatement(String)},
     *                          {@link #prepareStatement(String, int)}
     * @param student 要往PreparedStatement设置的学生实体
     * @throws SQLException 数据库异常
     */
    @Override
    protected void setPojo(PreparedStatement preparedStatement, Student student) throws SQLException{
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2,student.getSchool());
    }

}
