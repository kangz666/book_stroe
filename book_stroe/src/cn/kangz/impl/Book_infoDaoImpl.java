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
		// ����������
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// ����ռλ��
		pstm.setString(1, id);
		
		// ִ�в���
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
		// ����������
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// ����ռλ��
		pstm.setString(1, name);
		
		// ִ�в���
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
		// ����������
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// ����ռλ��
		
		pstm.setString(1,b.getBook_name());
		pstm.setString(2,b.getBook_auther());
		pstm.setDouble(3,b.getBook_price());
		pstm.setString(4,b.getBook_type());
		pstm.setString(5,b.getBook_introdution());
		pstm.setString(6,b.getBook_id());
		//ִ�в���
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
		// ����������
		PreparedStatement pstm =null;
		
		try {
		pstm = this.conn.prepareStatement(sql);
			// ����ռλ��
		pstm.setString(1, b.getBook_id());
		pstm.setString(2,b.getBook_name() );
		pstm.setString(3,b.getBook_auther());
		pstm.setDouble(4, b.getBook_price());
		pstm.setString(5, b.getBook_type());
		pstm.setString(6,b.getBook_introdution());
		// ִ�в���
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
			//������
		pstm = this.conn.prepareStatement(sql);
		//����ռλ��
		pstm.setString(1, id);
		// ִ�в���
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

		// ����
		
		return flag;
	}

	@Override
	public ArrayList<Book_info> doselectall() {
		
		ArrayList<Book_info> list = new ArrayList<Book_info>();
		
		String sql = "select * from book_info";
		// ����������
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		// ִ�в���
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
		if(flag) {//����
			 sql = "select * from book_info where book_name like ? ";
		}else{//���
			 sql = "select * from book_info where book_id like ? ";
		}
		
		// ����������
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		//����ռλ��
		if(flag) {
			pstm.setString(1,"%" + bf.getBook_name() + "%"  );
		}else {
			pstm.setString(1,"%" + bf.getBook_id() + "%" );
		}
		
		// ִ�в���
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
		//num =2 �۸� =3�����ߣ�flag = false ���� =true ����
		String sql = null;
		if(num==2) {//�۸�
			if(flag) {//����
				sql = "select * from book_info order by book_price desc";
			}else {//����
				sql = "select * from book_info order by book_price asc";
			} 
		}else {//���ߣ�Ĭ�ϣ�
			if(flag) {//����
				sql = "select * from book_info order by book_auther desc";
			}else {//����
				sql = "select * from book_info order by book_auther asc";
			} 
		}
		// ����������
		PreparedStatement pstm =null;
		try {
		pstm = this.conn.prepareStatement(sql);
		// ִ�в���
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
