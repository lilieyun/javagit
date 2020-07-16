package lilieyun.study.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * @program: javalearning
 * @Date: 2018/7/11 11:36
 * @Author: hyman.hu
 * @Description: 测试类
 */
public class AccessUtilApp2 {
	private static final String dbURL = "jdbc:ucanaccess://" + "D:\\00_openmuc0.17.2\\MyTest\\DB\\hisdb.mdb";
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

	public static void main(String[] args)
			throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {

		// 查找数据
		String sqlStr = "SELECT ATime,SUM(AValue) AS A_SUM" + " FROM RMData08 "
				+ " WHERE SwitchID IN(3,4) AND TagID=16 and ADate=6794 and ATime BETWEEN 400 AND 420 "
				+ " GROUP BY ATime ";
		// 查找数据

		Connection con;
		Statement stmt;
		try {
			con = DriverManager.getConnection(dbURL);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlStr);
			while (rs.next()) {
				System.out.println(rs.getString("A_SUM"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * 带参数查询 List<Object> params = new ArrayList<>(); params.add(18);
		 * params.add("李四");
		 * 
		 * List<User> list =
		 * DBUtils.select("select * from User where UserId>? and  UserName<>?",params,
		 * User.class); System.out.println(list);
		 */
		/*
		 * 带参数update String sql =
		 * "insert into User (UserName,RoleID,Psw,RoleName) values (?,?,?,?)";
		 * List<Object> list2 = new ArrayList<>(); list2.add("andy"); list2.add(10);
		 * list2.add("psw0211"); list2.add("Admin");
		 * 
		 * System.out.println(DBUtils.update(sql, list2)); System.out.println(sql);
		 */

	}

}