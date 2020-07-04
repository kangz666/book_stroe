package cn.kangz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.kangz.dao.UserDao;
import cn.kangz.pojo.User;

public class UserDaoImpl implements UserDao {

	private Connection conn = null;
	
	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean login(User u) {
		boolean flag=false;
		
		String sql = "select * from Users where username = ? and password = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		pstm.setString(1, u.getUsername());
		pstm.setString(2, u.getPassword());
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

	@Override
	public boolean resgis(User u)  {
	
	boolean flag=false;
		String sql = "insert into Users values(?,?,?,?,?)";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		pstm.setString(1, u.getUsername());
		pstm.setString(2, u.getPassword());
		pstm.setString(3, u.getName());
		pstm.setString(4, u.getIphonenumber());
		pstm.setString(5, u.getAddress());
		// 执行操作
		int executeUpdate = pstm.executeUpdate();
		if(executeUpdate == 1) {
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

	@Override
	public  User forget(String username,String iphonenumber) {
		User u = new User("未找到","未找到","未找到","未找到","未找到");
		String sql = "select * from Users where username = ? and  iphonenumber= ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		pstm.setString(1, username);
		pstm.setString(2, iphonenumber);
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		if(resultSet.next()) {
			u.setUsername(resultSet.getString("username"));
			u.setPassword(resultSet.getString("password"));
			u.setName(resultSet.getString("name"));
			u.setIphonenumber(resultSet.getString("iphonenumber"));
			u.setAddress(resultSet.getString("address"));
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
		return u;
	}

	@Override
	public boolean iscontain(User u) {
		boolean flag=false;
		
		String sql = "select username from Users where username = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		pstm.setString(1, u.getUsername());
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

	@Override
	public User doselect(String username) {
		User u = new User();
		String sql = "select * from Users where username = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		pstm.setString(1, username);
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		if(resultSet.next()) {
			u.setUsername(resultSet.getString("username"));
			u.setPassword(resultSet.getString("password"));
			u.setName(resultSet.getString("name"));
			u.setIphonenumber(resultSet.getString("iphonenumber"));
			u.setAddress(resultSet.getString("address"));
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
		return u;
	}

	@Override
	public boolean update(User u) {
		boolean flag=false;
		
		String sql = "update Users set password =? ,name = ?,iphonenumber = ?,address = ? where username = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		pstm.setString(1, u.getPassword());
		pstm.setString(2, u.getName());
		pstm.setString(3,u.getIphonenumber());
		pstm.setString(4, u.getAddress());
		pstm.setString(5, u.getUsername());
		
		// 执行操作
		int executeUpdate = pstm.executeUpdate();
		if(executeUpdate == 1) {
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
