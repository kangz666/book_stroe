package cn.kangz.test.junit;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import cn.kangz.dao.Book_infoDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.Book_infoDaoImpl;
import cn.kangz.pojo.Book_info;
import junit.framework.TestCase;

class Book_infoDaoTest {

//	@Test
//	void testDoselectid() {
//		/*
//	 	this.book_id = book_id;
//	 	this.book_name = book_name;
//		this.book_auther = book_auther;
//		this.book_price = book_price;
//		this.book_type = book_type;
//		this.book_introdution = book_introdution;
//	 */
//	DatabaseConnection dbc = new DatabaseConnection();
//	Connection conn = dbc.getConnection();
//	Book_infoDao bd = new Book_infoDaoImpl(conn);
//	//��ѯ�Ƿ�ɹ�
//	TestCase.assertNotNull(bd.doselectid("1005"));
//	}
//
//	@Test
//	void testDoselectname() {
//		/*
//	 	this.book_id = book_id;
//	 	this.book_name = book_name;
//		this.book_auther = book_auther;
//		this.book_price = book_price;
//		this.book_type = book_type;
//		this.book_introdution = book_introdution;
//	 */
//	DatabaseConnection dbc = new DatabaseConnection();
//	Connection conn = dbc.getConnection();
//	Book_infoDao bd = new Book_infoDaoImpl(conn);
//	//��ѯ�Ƿ�ɹ�
//	TestCase.assertNotNull(bd.doselectname("���μ�"));
//	}
//
//	@Test
//	void testDoupdate() {
//		/*
//	 	this.book_id = book_id;
//	 	this.book_name = book_name;
//		this.book_auther = book_auther;
//		this.book_price = book_price;
//		this.book_type = book_type;
//		this.book_introdution = book_introdution;
//	 */
//	DatabaseConnection dbc = new DatabaseConnection();
//	Connection conn = dbc.getConnection();
//	Book_infoDao bd = new Book_infoDaoImpl(conn);
//	//�޸��Ƿ�ɹ�
//	TestCase.assertTrue(bd.doupdate(new Book_info("1004","��¥��","��ѩ��",9.9,"����","�Ĵ��������������")));
//	}
//
	@Test
	void testDoinsert() {
		/*
		 	this.book_id = book_id;
		 	this.book_name = book_name;
			this.book_auther = book_auther;
			this.book_price = book_price;
			this.book_type = book_type;
			this.book_introdution = book_introdution;
		 */
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		Book_infoDao bd = new Book_infoDaoImpl(conn);
		String[] string = {"֪ʶ3","��ѧ","С˵","����"};
		String[] string1= {"abcff","edf","kiu","fgh"};
		String[] string2 = {"nbff","","lj","byk","kbd"};
		String[] string3 = {"eeefff","fdgdf","dfgfd","dfgfg"};
		
		//�����Ƿ�ɹ�
		//for(int j =0;j<4;j++) {
			int j=0;
		for(int i = 1;i<1000;i++) {
			
			TestCase.assertTrue(bd.doinsert(new Book_info("o147"+i,string3[j],string1[j],85.9+i*2,string[j],string2[j])));
			}
		//}
		
	}
//
//	@Test
//	void testDodelete() {
//		/*
//	 	this.book_id = book_id;
//	 	this.book_name = book_name;
//		this.book_auther = book_auther;
//		this.book_price = book_price;
//		this.book_type = book_type;
//		this.book_introdution = book_introdution;
//	 */
//	DatabaseConnection dbc = new DatabaseConnection();
//	Connection conn = dbc.getConnection();
//	Book_infoDao bd = new Book_infoDaoImpl(conn);
//	//ɾ���Ƿ�ɹ�
//	TestCase.assertTrue(bd.dodelete("1008"));
//	}
//
//	@Test
//	void testDoselectall() {
//		/*
//	 	this.book_id = book_id;
//	 	this.book_name = book_name;
//		this.book_auther = book_auther;
//		this.book_price = book_price;
//		this.book_type = book_type;
//		this.book_introdution = book_introdution;
//	 */
//	DatabaseConnection dbc = new DatabaseConnection();
//	Connection conn = dbc.getConnection();
//	Book_infoDao bd = new Book_infoDaoImpl(conn);
//	//��ѯȫ���Ƿ�ɹ�
//	TestCase.assertNotNull(bd.doselectall());
//	}

}
