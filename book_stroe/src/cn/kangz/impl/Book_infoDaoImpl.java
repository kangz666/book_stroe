package cn.kangz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.kangz.dao.Book_infoDao;
import cn.kangz.pojo.Book_info;

public class Book_infoDaoImpl implements Book_infoDao {
	private  Connection conn=null;
	
	public Book_infoDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Book_info doselectid(String id) {
		Book_info b= new Book_info();
		String sql = "select * from book_info where book_id = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		pstm.setString(1, id);
		
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		if(resultSet.next()) {
			b.setBook_id(resultSet.getString("book_id"));
			b.setBook_name(resultSet.getString("book_name"));
			b.setBook_auther(resultSet.getString("book_auther"));
			b.setBook_price(resultSet.getDouble("book_price")); 
			b.setBook_type(resultSet.getString("book_type"));
			b.setBook_introdution(resultSet.getString("book_introdution"));
			
			
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
		
		return b;
	}
	@Override
	public Book_info doselectname(String name) {
		Book_info b= new Book_info();
		String sql = "select * from book_info where book_name = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		pstm.setString(1, name);
		
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		if(resultSet.next()) {
			b.setBook_id(resultSet.getString("book_id"));
			b.setBook_name(resultSet.getString("book_name"));
			b.setBook_auther(resultSet.getString("book_auther"));
			b.setBook_price(resultSet.getDouble("book_price")); 
			b.setBook_type(resultSet.getString("book_type"));
			b.setBook_introdution(resultSet.getString("book_introdution"));
			
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
		
		return b;
	}

	@Override
	public boolean doupdate(Book_info b) {
		boolean flag=false;
		String sql = "update book_info set book_name=?,book_auther=?,book_price=?,book_type=?,book_introdution=? where book_id=?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		
		pstm.setString(1,b.getBook_name());
		pstm.setString(2,b.getBook_auther());
		pstm.setDouble(3,b.getBook_price());
		pstm.setString(4,b.getBook_type());
		pstm.setString(5,b.getBook_introdution());
		pstm.setString(6,b.getBook_id());
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

	@Override
	public boolean doinsert(Book_info b) {
		boolean flag = false;
		String sql = "insert into book_info values(?,?,?,?,?,?)";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		pstm.setString(1, b.getBook_id());
		pstm.setString(2,b.getBook_name() );
		pstm.setString(3,b.getBook_auther());
		pstm.setDouble(4, b.getBook_price());
		pstm.setString(5, b.getBook_type());
		pstm.setString(6,b.getBook_introdution());
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
	public boolean dodelete(String id) {
		boolean flag = false;
		String sql = "delete from book_info where book_id = ?";
		PreparedStatement pstm =null;
		try {
			//语句对象
		pstm = this.conn.prepareStatement(sql);
		//设置占位符
		pstm.setString(1, id);
		// 执行操作
		int executeUpdate = pstm.executeUpdate();
		if(executeUpdate == 1) {
			flag = true;
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 返回
		
		return flag;
	}

	@Override
	public ArrayList<Book_info> doselectall() {
		
		ArrayList<Book_info> list = new ArrayList<Book_info>();
		
		String sql = "select * from book_info";
		// 创建语句对象
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		while(resultSet.next()) {
			Book_info b= new Book_info();
			b.setBook_id(resultSet.getString("book_id"));
			b.setBook_name(resultSet.getString("book_name"));
			b.setBook_auther(resultSet.getString("book_auther"));
			b.setBook_price(resultSet.getDouble("book_price")); 
			b.setBook_type(resultSet.getString("book_type"));
			b.setBook_introdution(resultSet.getString("book_introdution"));
			
			list.add(b);	
		}
		resultSet.close();
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
		return list;
	}

	@Override
	public ArrayList<Book_info> doselectlike(Book_info bf,boolean flag) {
		ArrayList<Book_info> list = new ArrayList<Book_info>();
		String sql=null;
		if(flag) {//书名
			 sql = "select * from book_info where book_name like ? ";
		}else{//编号
			 sql = "select * from book_info where book_id like ? ";
		}
		
		// 创建语句对象
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		//设置占位符
		if(flag) {
			pstm.setString(1,"%" + bf.getBook_name() + "%"  );
		}else {
			pstm.setString(1,"%" + bf.getBook_id() + "%" );
		}
		
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		while(resultSet.next()) {
			Book_info b= new Book_info();
			b.setBook_id(resultSet.getString("book_id"));
			b.setBook_name(resultSet.getString("book_name"));
			b.setBook_auther(resultSet.getString("book_auther"));
			b.setBook_price(resultSet.getDouble("book_price")); 
			b.setBook_type(resultSet.getString("book_type"));
			b.setBook_introdution(resultSet.getString("book_introdution"));
			
			list.add(b);	
		}
		resultSet.close();
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
		return list;
	}

	@Override
	public ArrayList<Book_info> doselectsort(int num, boolean flag) {
		ArrayList<Book_info> list = new ArrayList<Book_info>();
		//num =2 价格 =3是作者，flag = false 升序 =true 降序
		String sql = null;
		if(num==2) {//价格
			if(flag) {//降序
				sql = "select * from book_info order by book_price desc";
			}else {//升序
				sql = "select * from book_info order by book_price asc";
			} 
		}else {//作者（默认）
			if(flag) {//降序
				sql = "select * from book_info order by book_auther desc";
			}else {//升序
				sql = "select * from book_info order by book_auther asc";
			} 
		}
		// 创建语句对象
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		while(resultSet.next()) {
			Book_info b= new Book_info();
			b.setBook_id(resultSet.getString("book_id"));
			b.setBook_name(resultSet.getString("book_name"));
			b.setBook_auther(resultSet.getString("book_auther"));
			b.setBook_price(resultSet.getDouble("book_price")); 
			b.setBook_type(resultSet.getString("book_type"));
			b.setBook_introdution(resultSet.getString("book_introdution"));

			list.add(b);	
		}
		resultSet.close();
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
		return list;
	}

}
