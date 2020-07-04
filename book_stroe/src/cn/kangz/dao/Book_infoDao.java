/**
 * 数据接口包
 */
package cn.kangz.dao;

import java.util.ArrayList;

import cn.kangz.pojo.Book_info;
/**
 * 这是一个对图书的操作的接口
 * @author kz
 *
 */
public interface Book_infoDao {
	/**
	 * 这是一个对按图书ID图书查找的方法
	 * @param 图书对象
	 * @return 查找到这图书
	 */
	public abstract Book_info doselectid(String id);
	/**
	 * 这是一个对按图书名图书查找的方法
	 * @param name 图书对象
	 * @return 查找到这图书
	 */
	public abstract Book_info doselectname(String name);
	/**
	 * 这是一个对图书进行修改的
	 * @param b 图书对象
	 * @return 是否修改成功
	 */
	public abstract boolean doupdate(Book_info b);
	/**
	 * 这是一个对图书进行插入的方法
	 * @param b 图书对象
	 * @return 是否插入成功
	 */
	public abstract boolean doinsert(Book_info b);
	/**
	 * 这是一个对图书进入删除的操作方法
	  * @param b 图书对象
	 * @return 是否删除成功
	 */
	public abstract boolean dodelete(String id);
	/**
	 * 这是一个对数据库的全部查询的操作的方法
	 * @return 图书集合对象
	 */
	public abstract ArrayList<Book_info> doselectall();
	/**
	  *   这是一个对编号和书名的一个模糊查找的功能
	 * @param b  查找的对象
	 * @param flag  false=按编号，true=按书名
	 * @return
	 */
	public abstract ArrayList<Book_info> doselectlike(Book_info b,boolean flag);
	/**
	  * 这是一个对编号和价格，作者的一个排序（升序和降序）的功能
	 * @param num   2  价格    3是作者
	 * @param flag   flag = false 升序 =true 降序
	 * @return图书集合
	 */
	public abstract ArrayList<Book_info> doselectsort(int num,boolean flag);
}
