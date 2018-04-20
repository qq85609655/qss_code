package com.fr.hailian.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fr.hailian.core.Constants;
import com.jfinal.kit.PropKit;
/***
 * JDBC工具类
 * @author Tom
 *
 */
public class JDBCUtil {

	private static CallableStatement callableStatement = null;
	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private  ResultSet rst = null;

	/***
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		 conn = DriverManager.getConnection(Constants.JDBC_HUB,
				Constants.JDBC_USER_HUB, Constants.JDBC_USER_PWD_HUB);
		return conn;
	}
	
	/***
	 * 关闭连接
	 * @param conn
	 * @throws SQLException
	 */
	public static void closeConnection(Connection conn) throws SQLException{
		conn.close();
	}

	public static Connection getConnection1() {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(Constants.JDBC_HUB,
                    Constants.JDBC_USER_HUB, Constants.JDBC_USER_PWD_HUB);

		} catch (ClassNotFoundException e) {e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection getInsightConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(PropKit.get("insight_jdbc"),
					PropKit.get("insight_user"), PropKit.get("insight_pwd"));

		} catch (ClassNotFoundException e) {e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * insert update delete SQL语句的执行的统一方法
	 * @param sql SQL语句
	 * @param params 参数数组，若没有参数则为null
	 * @return 受影响的行数
	 */
	public static int executeUpdate(String sql, Object[] params) {
		// 受影响的行数
		int affectedLine = 0;

		try {
			// 获得连接
			conn = JDBCUtil.getConnection1();
			// 调用SQL
			pst = conn.prepareStatement(sql);

			// 参数赋值
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
            /*在此 PreparedStatement 对象中执行 SQL 语句，
                                          该语句必须是一个 SQL 数据操作语言（Data Manipulation Language，DML）语句，比如 INSERT、UPDATE 或 DELETE
                                          语句；或者是无返回内容的 SQL 语句，比如 DDL 语句。    */
			// 执行
			affectedLine = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			// 释放资源
			JDBCUtil.closeAll();
		}
		return affectedLine;
	}
	public static int executeUpdate(String sql, Object[] params,String type) {
		// 受影响的行数
		int affectedLine = 0;

		try {
			// 获得连接
			if ("hub".equals(type)) {
				conn = JDBCUtil.getConnection1();
			}else if("insight".equals(type)){
				conn = JDBCUtil.getInsightConnection();
			}

			// 调用SQL
			pst = conn.prepareStatement(sql);

			// 参数赋值
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
            /*在此 PreparedStatement 对象中执行 SQL 语句，
                                          该语句必须是一个 SQL 数据操作语言（Data Manipulation Language，DML）语句，比如 INSERT、UPDATE 或 DELETE
                                          语句；或者是无返回内容的 SQL 语句，比如 DDL 语句。    */
			// 执行
			affectedLine = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 释放资源
			JDBCUtil.closeAll();
		}
		return affectedLine;
	}
	/**
	 * SQL 查询将查询结果直接放入ResultSet中
	 * @param sql SQL语句
	 * @param params 参数数组，若没有参数则为null
	 * @return 结果集
	 */
	private  ResultSet executeQueryRS(String sql, Object[] params) {
		try {
			// 获得连接
			conn = JDBCUtil.getConnection1();

			// 调用SQL
			pst = conn.prepareStatement(sql);

			// 参数赋值
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}

			// 执行
			rst = pst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return rst;
	}

	/**
	 * SQL 查询将查询结果：一行一列
	 * @param sql SQL语句
	 * @param params 参数数组，若没有参数则为null
	 * @return 结果集
	 */
	public static Object executeQuerySingle(String sql, Object[] params) {
		Object object = null;
		try {
			// 获得连接
			conn = JDBCUtil.getConnection1();

			// 调用SQL
			pst = conn.prepareStatement(sql);

			// 参数赋值
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}

//			// 执行
//			rst = pst.executeQuery();
//
//			if(rst.next()) {
//				object = rst.getObject(1);
//			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeAll();
		}

		return object;
	}

	/**
	 * 获取结果集，并将结果放在List中
	 *
	 * @param sql  SQL语句
	 *         params  参数，没有则为null
	 * @return List
	 *                       结果集
	 */
	public  List<Object> excuteQuery(String sql, Object[] params) {
		// 执行SQL获得结果集
		ResultSet rs = executeQueryRS(sql, params);

		// 创建ResultSetMetaData对象
		ResultSetMetaData rsmd = null;

		// 结果集列数
		int columnCount = 0;
		try {
			rsmd = rs.getMetaData();

			// 获得结果集列数
			columnCount = rsmd.getColumnCount();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}

		// 创建List
		List<Object> list = new ArrayList<Object>();

		try {
			// 将ResultSet的结果保存到List中
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					map.put(rsmd.getColumnLabel(i), rs.getObject(i));
				}
				list.add(map);//每一个map代表一条记录，把所有记录存在list中
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 关闭所有资源
			closeAll();
		}

		return list;
	}

	/**
	 * 存储过程带有一个输出参数的方法
	 * @param sql 存储过程语句
	 * @param params 参数数组
	 * @param outParamPos 输出参数位置
	 * @param SqlType 输出参数类型
	 * @return 输出参数的值
	 */
	public Object excuteQuery(String sql, Object[] params,int outParamPos, int SqlType) throws SQLException, ClassNotFoundException {
		Object object = null;
		conn = this.getConnection1();
		try {
			// 调用存储过程
			// prepareCall:创建一个 CallableStatement 对象来调用数据库存储过程。
			callableStatement = conn.prepareCall(sql);

			// 给参数赋值
			if(params != null) {
				for(int i = 0; i < params.length; i++) {
					callableStatement.setObject(i + 1, params[i]);
				}
			}

			// 注册输出参数
			callableStatement.registerOutParameter(outParamPos, SqlType);

			// 执行
			callableStatement.execute();

			// 得到输出参数
			object = callableStatement.getObject(outParamPos);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 释放资源
			closeAll();
		}

		return object;
	}

	/**
	 * 关闭所有资源
	 */
	private static void closeAll() {
		// 关闭结果集对象
//		if (rst != null) {
//			try {
//				rst.close();
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			}
//		}

		// 关闭PreparedStatement对象
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// 关闭CallableStatement 对象
		if (callableStatement != null) {
			try {
				callableStatement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// 关闭Connection 对象
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
