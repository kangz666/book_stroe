
package cn.kangz.dao;

import java.util.ArrayList;

import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Shop_cart;
import cn.kangz.pojo.User;
/**
 * 这是一个购物车的操作的接口
 * @author kz
 *
 */
public interface Shop_cartDao {
	/**
	 *  * 这是一个将图书添加到购物车的方法
	 * @param b图书类对象
	 * @param u 用户
	 * @param num  添加的数量
	 * @return 是否添加成功
	 */
	public abstract boolean doinsert(Book_info b,User u,int num);
	/**
	 * 这是将购物车的图书删除的方法
	 * @param s 购物车对象
	 * @param u 用户
	 * @return 删除是否成功
	 */
	public abstract boolean dodelete(Shop_cart s,User u);
	/**
	 * 这是一个可以在购物车里增加数量的方法
	 * @param num 增加的数量
	 * @param u 用户
	 * @return 是否增加成功
	 */
	public abstract boolean doupdate(Shop_cart s,User u,int num);
	/**
	 * 这是查找购物车的图书方法
	 * @param u 用户
	 * @return 购物车的集合
	 */
	public abstract ArrayList<Shop_cart> doselectall(User u);
	/**
	 * 这是一个在购物车里查找的图书的方法
	 * @param b 图书
	 * @param u 用户
	 * @return 是否查找到该图书
	 */
	public abstract Shop_cart doselect(Book_info b,User u);
}
