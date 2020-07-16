package lilieyun.study.db;

import java.sql.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * @program: javalearning
 * @Date: 2018/7/11 11:36
 * @Author: hyman.hu
 * @Description: ������
 */
public class AccessUtilApp {
	

	public static void main(String[] args)
			throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {

		// ��������
		String sqlStr = "SELECT ATime,SUM(AValue) AS A_SUM" + " FROM RMData08 "
				+ " WHERE SwitchID IN(3,4) AND TagID=16 and ADate=6794 and ATime BETWEEN 400 AND 420 "
				+ " GROUP BY ATime ";
		List<Map<String, Object>> records = new ArrayList<>();
		records = DBUtils.select(sqlStr, null);
		
		Gson gson=new Gson();
		String jsonStr=null;
		jsonStr=gson.toJson(records);
		System.out.println(jsonStr);
		
		for (int i = 0; i < records.size(); i++) {// �ڲ���������Ч����ߣ����ڶ��߳�Ҫ���ǲ������������⡣
			Map<String, Object> record = records.get(i);
			
			for (Object v : record.values()) {
				System.out.print(" " + v);
			}
			System.out.println();
		}

		/*
		 * ��������ѯ List<Object> params = new ArrayList<>(); params.add(18);
		 * params.add("����");
		 * 
		 * List<User> list =
		 * DBUtils.select("select * from User where UserId>? and  UserName<>?",params,
		 * User.class); System.out.println(list);
		 */
		/*
		 * ������update String sql =
		 * "insert into User (UserName,RoleID,Psw,RoleName) values (?,?,?,?)";
		 * List<Object> list2 = new ArrayList<>(); list2.add("andy"); list2.add(10);
		 * list2.add("psw0211"); list2.add("Admin");
		 * 
		 * System.out.println(DBUtils.update(sql, list2)); System.out.println(sql);
		 */

	}

}