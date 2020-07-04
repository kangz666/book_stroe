package cn.kangz.dbc;
/**
 * 这个是负责数据库的连接类
 * @author kz
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=book_stroe";
	private static final String USER = "sa";
	private static final String PASSWORD = "123456";
	
	private Connection conn=null;

	public DatabaseConnection() {
		try {
			Class.forName(DRIVER);//加载驱动
		    this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	/**
	 * 取得数据库连接对象
	 * @return 实例化的Connection对象，如果返回null，就表示没有连接成功
	 */
	public Connection getConnection() {
		return this.conn;
		
	}
	/**
	 * 这是对数据库的关闭
	 */
	public void close() {
		if(this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
