package lilieyun.study.db;

import java.sql.*;

/**
 * https://blog.csdn.net/m0_37204491/article/details/81010758
 * @program: javalearning
 * @Date: 2018/7/11 11:03
 * @Author: hyman.hu
 * @Description: ������
 */
public class AccessDBUtils {

    private static final String dbURL = "jdbc:ucanaccess://" +
            "D:\\00_openmuc0.17.2\\MyTest\\DB\\hisdb.mdb";

    /*
     * ��������
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

    //��������
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

    // �ر���Դ
    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();// ��������쳣�ˣ�rs�ر����𣿣����û����ô���,ps , conҲ��һ���ġ�
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
