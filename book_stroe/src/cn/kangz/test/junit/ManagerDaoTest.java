package cn.kangz.test.junit;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import cn.kangz.dao.ManagerDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.ManagerDaoImpl;
import cn.kangz.pojo.Manager;
import cn.kangz.pojo.User;
import junit.framework.TestCase;

class ManagerDaoTest {

	@Test
	void testdologin() {
		DatabaseConnection dc = new DatabaseConnection();
		Connection conn = dc.getConnection();
		ManagerDao md = new ManagerDaoImpl(conn);
		TestCase.assertTrue(md.dologin(new Manager("abc123","6666")));	
		dc.close();
	}
	@Test
	void testdoupdate() {
		DatabaseConnection dc = new DatabaseConnection();
		Connection conn = dc.getConnection();
		ManagerDao md = new ManagerDaoImpl(conn);
		TestCase.assertTrue(md.doupdate(new Manager("abc123","8888","123456789","895623@qq.com")));	
		dc.close();
	}

}
