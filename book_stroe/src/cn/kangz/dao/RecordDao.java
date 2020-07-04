
package cn.kangz.dao;

import java.util.ArrayList;

import cn.kangz.pojo.Manager;
import cn.kangz.pojo.Record;
/**
 * 这是一个对记录的操作的接口
 * @author kz
 *
 */
public interface RecordDao {
	/**
	 * 这是一个将管理员的操作存入文件中
	 * @param m  管理员
	 * @param r  操作
	 * @return 是否存入成功
	 */
	public abstract  boolean inputrecord(Manager m,Record r);
	/**
	 * 这是一个将管理员的记录写入集合的方法
	 * @param m 管理员
	 * @return 记录集合
	 */
	public abstract ArrayList<Record> ouputList(Manager m);
	/**
	 * 这是一个将集合写入文件的方法
	 * @param list 记录集合
	 * @return 是否成功
	 */
	public abstract boolean inputrecordover(Manager m,ArrayList<Record> list);
	/**
	 * 这是一个将以管理员的名字创建文件
	 * @param m  管理员
	 * @return 是否成功
	 */
	public abstract boolean newfile(Manager m);
 }
