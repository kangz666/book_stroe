package cn.kangz.test.junit;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import cn.kangz.dao.Shop_cartDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.Shop_cartDaoImpl;
import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Shop_cart;
import cn.kangz.pojo.User;
import junit.framework.TestCase;

class Shop_cartDaoTest {

//	@Test
//	void testDoinsert() {
//		/*
//		 * private String book_id;
//			private String book_name;
//			private String book_auther;
//			private double book_price;
//			private String book_type;
//			private String book_introdution;
//		 */
//		DatabaseConnection dbc = new DatabaseConnection();
//		Connection conn = dbc.getConnection();
//		Shop_cartDao sd =new Shop_cartDaoImpl(conn);
//		boolean doinsert = sd.doinsert(new Book_info("1009","java编程思想","埃克尔",98.9,"学习","经典图书，深入学习编程思想"),
//				new User("2018900","123456","王三","110120","湖南省张家界"));
//		TestCase.assertTrue(doinsert);
//	}
//
//	@Test
//	void testDodelete() {
//		DatabaseConnection dbc = new DatabaseConnection();
//		Connection conn = dbc.getConnection();
//		Shop_cartDao sd =new Shop_cartDaoImpl(conn);
//		boolean dodelete = sd.dodelete(new Shop_cart("111","1008","西游记","54",88.9));
//		TestCase.assertTrue(dodelete);
//	}
//
//	@Test
//	void testDoupdate() {
//		DatabaseConnection dbc = new DatabaseConnection();
//		Connection conn = dbc.getConnection();
//		Shop_cartDao sd =new Shop_cartDaoImpl(conn);
//		sd.doupdate(new Shop_cart("111","1008","西游记","54",88.9), 9);
//	}

}
