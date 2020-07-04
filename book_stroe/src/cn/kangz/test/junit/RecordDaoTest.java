package cn.kangz.test.junit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import cn.kangz.dao.RecordDao;
import cn.kangz.impl.RecordDaoImpl;
import cn.kangz.pojo.Manager;
import cn.kangz.pojo.Record;
import junit.framework.TestCase;

class RecordDaoTest {

//	@Test
//	void testInputrecord() {
//		RecordDao rd = new RecordDaoImpl();
//		Date date = new Date(System.currentTimeMillis());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String string = sdf.format(date);
//		//System.out.println(string);String manager_id, String order_id, String type, String date, String money
//		boolean inputrecord = rd.inputrecord(new Manager("abc123","8888"), new Record("abc123","5552222255","ÍË¿î",string,"10000086"));
//		TestCase.assertTrue(inputrecord);
//	}
//
//	@Test
//	void testOuputList() {
//		RecordDao rd = new RecordDaoImpl();
//		ArrayList<Record> ouputList = rd.ouputList(new Manager("abc123","8888"));
//		System.out.println(ouputList);
//		TestCase.assertNotNull(ouputList);
//	}
//
//	@Test
//	void testInputrecordover() {
//		RecordDao rd = new RecordDaoImpl();
//		Date date = new Date(System.currentTimeMillis());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String string = sdf.format(date);
//		ArrayList<Record> ouputList = rd.ouputList(new Manager("abc123","8888"));
//		
//		ouputList.add(new Record("abc123","0000","ÍË¿î",string,"10000086"));
//		ouputList.add(new Record("abc","00","ÍË¿î",string,"100086"));
//		
//		boolean inputrecordover = rd.inputrecordover(new Manager("abc123","0000"),ouputList);
//		TestCase.assertTrue(inputrecordover);
//	}
//
//	@Test
//	void testNewfile() {
//		RecordDao rd = new RecordDaoImpl();
//		boolean newfile = rd.newfile(new Manager("abc123","8888"));
//		TestCase.assertTrue(newfile);
//	}

}
