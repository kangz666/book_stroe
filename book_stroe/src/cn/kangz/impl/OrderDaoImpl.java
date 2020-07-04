package cn.kangz.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import cn.kangz.dao.OrderDao;
import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Manager;
import cn.kangz.pojo.Order;
import cn.kangz.pojo.Shop_cart;
import cn.kangz.pojo.User;

public class OrderDaoImpl implements OrderDao {
	
	private Connection conn=null;
	
	public OrderDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	@Override
	public boolean doSubmit(Order o) {
		boolean flag = false;
		String sql = "insert into Orders values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// 创建语句对象
		PreparedStatement pstm =null;
		//long time = System.currentTimeMillis();
		// Date date = new Date(time);   
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");   
//		String dateStringParse = sdf.format(date);  
		try {
		pstm = this.conn.prepareStatement(sql);
		
//			// 设置占位符
//		pstm.setString(1,String.valueOf(time));
//		pstm.setString(2,b.getBook_id());
//		pstm.setString(3,"  ");
//		pstm.setString(4, u.getUsername());
//		pstm.setString(5,b.getBook_name());
//		pstm.setString(6,s.getOrder_sum());
//		pstm.setDate(7,new java.sql.Date(new java.util.Date().getTime()));//当前的系统时间
//		pstm.setString(8,u.getName());
//		pstm.setString(9,u.getAddress());
//		pstm.setString(10, u.getIphonenumber());
//		pstm.setDouble(11, b.getBook_price());
//		pstm.setString(12,"否");
//		pstm.setString(13,);
		// 设置占位符
		pstm.setString(1,o.getOrder_id());
		pstm.setString(2,o.getBook_id());
		pstm.setString(3,o.getManager_id());
		pstm.setString(4,o.getUsername());
		pstm.setString(5,o.getBook_name());
		pstm.setString(6,o.getOrder_sum());
		pstm.setTimestamp(7,new Timestamp(new Date().getTime()));//当前的系统时间
		pstm.setString(8,o.getName());
		pstm.setString(9,o.getAddress());
		pstm.setString(10, o.getPhonenumber());
		pstm.setDouble(11, o.getPrice());
		pstm.setString(12,o.getOrder_state());
		pstm.setString(13,o.getOrder_remark());
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
	public ArrayList<Order> douserselect(User u) {
		
		ArrayList<Order> list = new ArrayList<Order>();
		
		String sql = "select * from Orders where username = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		pstm.setString(1, u.getUsername());
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		while(resultSet.next()) {
			/*private String order_id;  //订单号
			private String book_id;
			private String manager_id; //处理人
			private String username;  //用户名
			private String book_name;  //书名
			private String order_sum;  //图书数量
			private Date date;        //订单时间
			private String name;  //真实姓名
			private String address;
			private String phonenumber;
			private double price;//总价格
			private String order_state; //订单状态
			private String order_remark;//备注*/
			Order o= new Order();
			o.setOrder_id(resultSet.getString(1));
			o.setBook_id(resultSet.getString(2));
			o.setManager_id(resultSet.getString(3));
			o.setUsername(resultSet.getString(4));
			o.setBook_name(resultSet.getString(5));
			o.setOrder_sum(resultSet.getString(6));
			o.setDate(resultSet.getTimestamp(7));
			o.setName(resultSet.getString(8));
			o.setAddress(resultSet.getString(9));
			o.setPhonenumber(resultSet.getString(10));
			o.setPrice(resultSet.getDouble(11));
			o.setOrder_state(resultSet.getString(12));
			o.setOrder_remark(resultSet.getString(13));
			list.add(o);	
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
	public ArrayList<Order> domanagerrefundselect() {
		
		ArrayList<Order> list = new ArrayList<Order>();
		
		String sql = "select * from Orders where order_state = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		pstm.setString(1, "退款");
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		while(resultSet.next()) {
			/*private String order_id;  //订单号
			private String book_id;
			private String manager_id; //处理人
			private String username;  //用户名
			private String book_name;  //书名
			private String order_sum;  //图书数量
			private Date date;        //订单时间
			private String name;  //真实姓名
			private String address;
			private String phonenumber;
			private double price;//总价格
			private String order_state; //订单状态
			private String order_remark;//备注*/
			Order o= new Order();
			o.setOrder_id(resultSet.getString(1));
			o.setBook_id(resultSet.getString(2));
			o.setManager_id(resultSet.getString(3));
			o.setUsername(resultSet.getString(4));
			o.setBook_name(resultSet.getString(5));
			o.setOrder_sum(resultSet.getString(6));
			o.setDate(resultSet.getTimestamp(7));
			o.setName(resultSet.getString(8));
			o.setAddress(resultSet.getString(9));
			o.setPhonenumber(resultSet.getString(10));
			o.setPrice(resultSet.getDouble(11));
			o.setOrder_state(resultSet.getString(12));
			o.setOrder_remark(resultSet.getString(13));
			list.add(o);	
		}
		resultSet.close();
		} catch (SQLException e) {
			
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
	public ArrayList<Order> domanagerfalseselect() {
ArrayList<Order> list = new ArrayList<Order>();
		
		String sql = "select * from Orders where order_state = ? order by date desc";
		// 创建语句对象
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		pstm.setString(1, "未处理");
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		while(resultSet.next()) {
			/*private String order_id;  //订单号
			private String book_id;
			private String manager_id; //处理人
			private String username;  //用户名
			private String book_name;  //书名
			private String order_sum;  //图书数量
			private Date date;        //订单时间
			private String name;  //真实姓名
			private String address;
			private String phonenumber;
			private double price;//总价格
			private String order_state; //订单状态
			private String order_remark;//备注*/
			Order o= new Order();
			o.setOrder_id(resultSet.getString(1));
			o.setBook_id(resultSet.getString(2));
			o.setManager_id(resultSet.getString(3));
			o.setUsername(resultSet.getString(4));
			o.setBook_name(resultSet.getString(5));
			o.setOrder_sum(resultSet.getString(6));
			o.setDate(resultSet.getTimestamp(7));
			o.setName(resultSet.getString(8));
			o.setAddress(resultSet.getString(9));
			o.setPhonenumber(resultSet.getString(10));
			o.setPrice(resultSet.getDouble(11));
			o.setOrder_state(resultSet.getString(12));
			o.setOrder_remark(resultSet.getString(13));
			list.add(o);	
		}
		resultSet.close();
		} catch (SQLException e) {
			
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
	public boolean doUpdateorder(Order o, Manager m,String handle) {
		boolean flag=false;
		String sql = "update Orders set manager_id = ?,order_state = ? where order_id = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
		// 设置占位符
		pstm.setString(1, m.getManager_id());
		pstm.setString(2, handle);
		pstm.setString(3, o.getOrder_id());
		
		
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
	public ArrayList<Order> domanagerallselect() {
		ArrayList<Order> list = new ArrayList<Order>();
		
		String sql = "select * from Orders order by date desc";
		// 创建语句对象
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		while(resultSet.next()) {
			/*private String order_id;  //订单号
			private String book_id;
			private String manager_id; //处理人
			private String username;  //用户名
			private String book_name;  //书名
			private String order_sum;  //图书数量
			private Date date;        //订单时间
			private String name;  //真实姓名
			private String address;
			private String phonenumber;
			private double price;//总价格
			private String order_state; //订单状态
			private String order_remark;//备注*/
			Order o= new Order();
			o.setOrder_id(resultSet.getString(1));
			o.setBook_id(resultSet.getString(2));
			o.setManager_id(resultSet.getString(3));
			o.setUsername(resultSet.getString(4));
			o.setBook_name(resultSet.getString(5));
			o.setOrder_sum(resultSet.getString(6));
			o.setDate(resultSet.getTimestamp(7));
			o.setName(resultSet.getString(8));
			o.setAddress(resultSet.getString(9));
			o.setPhonenumber(resultSet.getString(10));
			o.setPrice(resultSet.getDouble(11));
			o.setOrder_state(resultSet.getString(12));
			o.setOrder_remark(resultSet.getString(13));
			list.add(o);	
		}
		resultSet.close();
		} catch (SQLException e) {
			
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
	public boolean doUpdate(Order o, String Manager_id) {
		boolean flag=false;
		String sql = "update Orders set manager_id = ?,order_state = ?, order_remark = ? where order_id = ?";
		// 创建语句对象
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
		// 设置占位符
		pstm.setString(1, Manager_id);
		pstm.setString(2, o.getOrder_state());
		pstm.setString(3, o.getOrder_remark());
		pstm.setString(4, o.getOrder_id());
		
		
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
	public ArrayList<Order> doselectsort(User u) {
		

		ArrayList<Order> list = new ArrayList<Order>();
		
		String sql = "select * from Orders where username = ? order by price";
		// 创建语句对象
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		pstm.setString(1, u.getUsername());
		// 执行操作
		ResultSet resultSet = pstm.executeQuery();
		while(resultSet.next()) {
			/*private String order_id;  //订单号
			private String book_id;
			private String manager_id; //处理人
			private String username;  //用户名
			private String book_name;  //书名
			private String order_sum;  //图书数量
			private Date date;        //订单时间
			private String name;  //真实姓名
			private String address;
			private String phonenumber;
			private double price;//总价格
			private String order_state; //订单状态
			private String order_remark;//备注*/
			Order o= new Order();
			o.setOrder_id(resultSet.getString(1));
			o.setBook_id(resultSet.getString(2));
			o.setManager_id(resultSet.getString(3));
			o.setUsername(resultSet.getString(4));
			o.setBook_name(resultSet.getString(5));
			o.setOrder_sum(resultSet.getString(6));
			o.setDate(resultSet.getTimestamp(7));
			o.setName(resultSet.getString(8));
			o.setAddress(resultSet.getString(9));
			o.setPhonenumber(resultSet.getString(10));
			o.setPrice(resultSet.getDouble(11));
			o.setOrder_state(resultSet.getString(12));
			o.setOrder_remark(resultSet.getString(13));
			list.add(o);	
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
	public boolean dodelect(Manager m, Order o) {
		boolean flag = false;
		String sql = "delete from Orders where order_id = ?";
		PreparedStatement pstm =null;
		try {
			//语句对象
		pstm = this.conn.prepareStatement(sql);
		//设置占位符
		pstm.setString(1, o.getOrder_id());
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
	
	
	}
