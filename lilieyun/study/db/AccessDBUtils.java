package lilieyun.study.db;

import java.sql.*;

/**
 * https://blog.csdn.net/m0_37204491/article/details/81010758
 * @program: javalearning
 * @Date: 2018/7/11 11:03
 * @Author: hyman.hu
 * @Description: 工具类
 */
public class AccessDBUtils {

    private static final String dbURL = "jdbc:ucanaccess://" +
            "D:\\00_openmuc0.17.2\\MyTest\\DB\\hisdb.mdb";

    /*
     * 加载驱动
     */
    static {
        try {
            // Step 1: Loading or registering Oracle JDBC driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
    }
    
    private AccessDBUtils() {};

    //建立连接
	public static Connection getConn() {
        try {
            // Step 2: Opening database connection
            // Step 2.A: Create and get connection using DriverManager class
            return DriverManager.getConnection(dbURL);
        } catch (Exception e) {
            System.out.println("AccessDB connection fail");
            e.printStackTrace();
        }
        return null;
    }

    // 关闭资源
    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();// 这里出现异常了，rs关闭了吗？，如果没有怎么解决,ps , con也是一样的。
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (con != null)
                    try {
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}
