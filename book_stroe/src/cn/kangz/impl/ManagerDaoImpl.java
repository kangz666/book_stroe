package cn.kangz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.kangz.dao.ManagerDao;
import cn.kangz.pojo.Manager;

public class ManagerDaoImpl implements ManagerDao {
	
	private Connection conn = null;
	
	public ManagerDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean dologin(Manager m) {
		boolean flag=false;
		
		String sql = "select * from Manager where manager_id = ? and manager_password = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		pstm.setString(1,m.getManager_id());
		pstm.setString(2,m.getManager_password());
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		if(resultSet.next()) {
			flag = true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean doupdate(Manager m) {
		boolean flag=false;
		String sql = "update Manager set manager_password=?,manager_phonenumber=?,manager_email=? where manager_id=?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		
		pstm.setString(1,m.getManager_password());
		pstm.setString(2,m.getManager_phonenumber());
		pstm.setString(3,m.getManager_email());
		pstm.setString(4,m.getManager_id());
		//执行操作
		int update = pstm.executeUpdate();
		if(update ==1) {
			flag = true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
