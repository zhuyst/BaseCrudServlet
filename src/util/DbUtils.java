package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接的工具类
 * @author 朱悦星
 */
public class DbUtils {

    /**
     * 数据库驱动名
     */
    private final static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    /**
     * 数据库连接URL
     */
    private final static String URL = "jdbc:mysql://localhost:3306/lab?characterEncoding=utf-8&useSSL=false";

    /**
     * 数据库用户名
     */
    private final static String USERNAME = "test";

    /**
     * 数据库密码
     */
    private final static String PASSWORD = "zhuyst";

    static {
        try {
            Class.forName(DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个数据库的Connection
     * @return 获取到的Connection
     * @throws SQLException 数据库异常
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
