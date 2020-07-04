
package cn.kangz.test.junit;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import cn.kangz.dao.UserDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.UserDaoImpl;
import cn.kangz.pojo.User;
import junit.framework.TestCase;

/**
 * @author Lengths
 *
 */
class UserDaoTest {

//	@Test
//	void testresgis() throws Exception {
//		DatabaseConnection dc = new DatabaseConnection();
//		Connection conn = dc.getConnection();
//		UserDao ud=new UserDaoImpl(conn);
//		TestCase.assertTrue(ud.resgis(new User("2018900","123456","王三","110120","湖南省张家界")));  
//		dc.close();
//	}
//	@Test
//	void testlogin(){
//		DatabaseConnection dc = new DatabaseConnection();
//		Connection conn = dc.getConnection();
//		UserDao ud=new UserDaoImpl(conn);
//		TestCase.assertTrue(ud.login(new User("2018500","123456")));	
//		dc.close();
//	}
//	@Test
//	void testforget(){
//		DatabaseConnection dc = new DatabaseConnection();
//		Connection conn = dc.getConnection();
//		UserDao ud=new UserDaoImpl(conn);
//			 User forget = ud.forget("2018500", "110120");
//			 TestCase.assertNotNull(forget);
//			 dc.close();
//	}
//	@Test
//	void testdoselect(){
//		DatabaseConnection dc = new DatabaseConnection();
//		Connection conn = dc.getConnection();
//		UserDao ud=new UserDaoImpl(conn);
//		User doselect = ud.doselect("2018500");
//		 TestCase.assertNotNull(doselect);
//		dc.close();
//	}
	@Test
	void testupdate(){
		DatabaseConnection dc = new DatabaseConnection();
		Connection conn = dc.getConnection();
		UserDao ud=new UserDaoImpl(conn);
		boolean update = ud.update(new User("111","444","555","666","8888888888"));
		TestCase.assertTrue(update);
		dc.close();
	}

}
