package cn.kangz.dbc;
/**
 * ����Ǹ������ݿ��������
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
			Class.forName(DRIVER);//��������
		    this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	/**
	 * ȡ�����ݿ����Ӷ���
	 * @return ʵ������Connection�����������null���ͱ�ʾû�����ӳɹ�
	 */
	public Connection getConnection() {
		return this.conn;
		
	}
	/**
	 * ���Ƕ����ݿ�Ĺر�
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
