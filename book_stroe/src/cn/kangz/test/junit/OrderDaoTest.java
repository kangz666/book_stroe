package cn.kangz.test.junit;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import cn.kangz.dao.OrderDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.OrderDaoImpl;
import cn.kangz.pojo.Manager;
import cn.kangz.pojo.Order;
import cn.kangz.pojo.User;
import junit.framework.TestCase;

class OrderDaoTest {
/**
			private String order_id;  //������
			private String book_id;
			private String manager_id; //������
			private String username;  //�û���
			private String book_name;  //����
			private String order_sum;  //ͼ������
			private Date date;        //����ʱ��
			private String name;  //��ʵ����
			private String address;
			private String phonenumber;
			private double price;//�ܼ۸�
			private String order_state; //����״̬
			private String order_remark;//��ע
			*/

//	@Test
//	void testDoSubmit() {
//		DatabaseConnection dbc = new DatabaseConnection();
//		Connection conn = dbc.getConnection();
//		OrderDao od = new OrderDaoImpl(conn);
//		Order o = new Order("001323215465","6245656","56465485646","56564564654","645646","54654","465","546","4154",5646,"56465","465");
//		
//		boolean doSubmit = od.doSubmit(o);
//	dbc.close();
//		
//		TestCase.assertTrue(doSubmit);
//	}
//
//	@Test
//	void testDouserselect() {
//		DatabaseConnection dbc = new DatabaseConnection();
//		Connection conn = dbc.getConnection();
//		OrderDao od = new OrderDaoImpl(conn);
//		//Order o = new Order("001323215465","6245656","56465485646","56564564654","645646","54654","465","546","4154",5646,"56465","465");
//		
//		ArrayList<Order> douserselect = od.douserselect(new User("56564564654","111"));
//		TestCase.assertNotNull(douserselect);
//	dbc.close();
//	}
//
//	@Test
//	void testDomanagertrueselect() {
//		DatabaseConnection dbc = new DatabaseConnection();
//		Connection conn = dbc.getConnection();
//		OrderDao od = new OrderDaoImpl(conn);
//		//Order o = new Order("001323215465","6245656","56465485646","56564564654","645646","54654","465","546","4154",5646,"56465","465");
//		
//		ArrayList<Order> domanagertrueselect = od.domanagertrueselect();
//		TestCase.assertNotNull(domanagertrueselect);
//	dbc.close();
//	}
//
//	@Test
//	void testDomanagerfalseselect() {
//		DatabaseConnection dbc = new DatabaseConnection();
//		Connection conn = dbc.getConnection();
//		OrderDao od = new OrderDaoImpl(conn);
//		//Order o = new Order("001323215465","6245656","56465485646","56564564654","645646","54654","465","546","4154",5646,"56465","465");
//		
//		ArrayList<Order> domanagerfalseselect = od.domanagerfalseselect();
//		TestCase.assertNotNull(domanagerfalseselect);
//	dbc.close();
//	}
//
//	@Test
//	void testDomanagerallselect() {
//		DatabaseConnection dbc = new DatabaseConnection();
//		Connection conn = dbc.getConnection();
//		OrderDao od = new OrderDaoImpl(conn);
//		//Order o = new Order("001323215465","6245656","56465485646","56564564654","645646","54654","465","546","4154",5646,"56465","465");
//		
//		ArrayList<Order> domanagerallselect = od.domanagerallselect();
//		
//		TestCase.assertNotNull(domanagerallselect);
//	dbc.close();
//	}
//
//	@Test
//	void testDoUpdate() {
//		DatabaseConnection dbc = new DatabaseConnection();
//		Connection conn = dbc.getConnection();
//		OrderDao od = new OrderDaoImpl(conn);
//		Order o = new Order();
//		o.setOrder_id("001323215465");
//		o.setOrder_state("��");
//		boolean doUpdate = od.doUpdate(o,"sss");
//		TestCase.assertTrue(doUpdate);
//		dbc.close();
//	}
//
//	@Test
//	void testDoselectsort() {
//		DatabaseConnection dbc = new DatabaseConnection();
//		Connection conn = dbc.getConnection();
//		OrderDao od = new OrderDaoImpl(conn);
//		//Order o = new Order("001323215465","6245656","56465485646","56564564654","645646","54654","465","546","4154",5646,"56465","465");
//		
//		 ArrayList<Order> doselectsort = od.doselectsort(new User("111","444"));
//		
//		 	System.out.println(doselectsort);
//		TestCase.assertNotNull(doselectsort);
//	dbc.close();
//	}

}
