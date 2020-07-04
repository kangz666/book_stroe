package cn.kangz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.kangz.dao.Shop_cartDao;
import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Shop_cart;
import cn.kangz.pojo.User;

public class Shop_cartDaoImpl implements Shop_cartDao {
	private Connection conn =null;
	
	public Shop_cartDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean doinsert(Book_info b,User u,int num) {
		
		
		/*
		 * this.shop_no = shop_no;
			this.shop_id = shop_id;
			this.book_id = book_id;
			this.book_name = book_name;
			this.order_sum = order_sum;
			this.book_price = book_price;
		 */
		boolean flag = false;
		String sql = "insert into shop_cart values(?,?,?,?,?)";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
		// 设置占位符
		pstm.setString(1, u.getUsername());
		pstm.setString(2, b.getBook_id());
		pstm.setString(3, b.getBook_name());
		pstm.setInt(4, num);
		pstm.setDouble(5, b.getBook_price()*num);
		
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
	public boolean dodelete(Shop_cart s,User u) {
		boolean flag = false;
		String sql = "delete from shop_cart where book_id = ? and shop_id = ?";
		PreparedStatement pstm =null;
		try {
			//语句对象
		pstm = this.conn.prepareStatement(sql);
		//设置占位符
		pstm.setString(1, s.getBook_id());
		pstm.setString(2, u.getUsername());
		// 执行操作
		int executeUpdate = pstm.executeUpdate();
		if(executeUpdate > 1 || executeUpdate ==1) {
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
	public boolean doupdate(Shop_cart s,User u,int num) {
		boolean flag=false;
		String sql = "update shop_cart set order_sum = ? , book_price = ? where book_id=? and shop_id = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// 设置占位符
		String sum = String.valueOf(num);
		pstm.setString(1,sum);
		pstm.setDouble(2,(s.getBook_price()/Double.parseDouble(s.getOrder_sum()))*num);
		pstm.setString(3,s.getBook_id());
		pstm.setString(4, u.getUsername());
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
	public ArrayList<Shop_cart> doselectall(User u) {

			ArrayList<Shop_cart> list = new ArrayList<Shop_cart>();
			
			String sql = "select * from shop_cart where shop_id = ?";
			// 创建语句对象
			PreparedStatement pstm =null;
			try {
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, u.getUsername());
			// 执行操作
			ResultSet resultSet = pstm.executeQuery();
			while(resultSet.next()) {
				Shop_cart s= new Shop_cart();
				/*
				 * private String shop_id;
					private String book_id;
					private String book_name;
					private String order_sum;
					private double book_price;
				 */
				s.setShop_id(resultSet.getString("shop_id"));
				s.setBook_id(resultSet.getString("book_id"));
				s.setBook_name(resultSet.getString("book_name"));
				s.setOrder_sum(resultSet.getString("order_sum"));
				s.setBook_price(resultSet.getDouble("book_price"));
				list.add(s);	
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
	public Shop_cart doselect(Book_info b, User u) {
		Shop_cart s = new Shop_cart(null,null,null,null,0);
		String sql = "select * from shop_cart where shop_id = ? and book_id = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		pstm.setString(1, u.getUsername());
		pstm.setString(2, b.getBook_id());
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		if(resultSet.next()) {
			s.setShop_id(resultSet.getString("shop_id"));
			s.setBook_id(resultSet.getString("book_id"));
			s.setBook_name(resultSet.getString("book_name"));
			s.setOrder_sum(resultSet.getString("order_sum"));
			s.setBook_price(resultSet.getDouble("book_price"));
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
		return s;
	}
	

}
