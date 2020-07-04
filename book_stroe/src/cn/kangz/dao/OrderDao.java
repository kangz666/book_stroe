
package cn.kangz.dao;

import java.util.ArrayList;

import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Manager;
import cn.kangz.pojo.Order;
import cn.kangz.pojo.Shop_cart;
import cn.kangz.pojo.User;
/**
 * 这是一个对订单的操作的接口
 * @author kz
 *
 */
public interface OrderDao {
	/**
	 * 这是一个提交购买图书的方法
	 * @param o 订单 
	 * @return 是否成功
	 */
	public abstract boolean doSubmit(Order o);
	/**
	 * 这是一个用户自己的查找订单中的订单详情
	 * @param u 用户
	 * @return 集合
	 */
	public abstract ArrayList<Order> douserselect(User u);
	/**
	 * 查找管理员处理退款的订单
	 * @return 集合
	 */
	public abstract ArrayList<Order> domanagerrefundselect();
	/**
	 * z这是一个修改退款的方法
	 * @param o 订单
	 * @param m 管理员
	 * @param handle 处理方式
	 * @return 是否成功
	 */
	public boolean doUpdateorder(Order o, Manager m,String handle);
	/**
	 * 查找管理员未处理的订单
	 * @return 集合
	 */
	public abstract ArrayList<Order> domanagerfalseselect();
	/**
	 * 查找用户的所有订单
	 * @return 集合
	 */
	public abstract ArrayList<Order> domanagerallselect();
	/**
	 * 这是一个管理员处理订单的方法，修改操作
	 * @param o 订单
	 * @param Manager_id 管理员名
	 * @return  是否修改成功
	 */
	public abstract boolean doUpdate(Order o,String Manager_id);
	/**
	 * 这是一个排序按照价格的方法
	 * @param u 用户对象
	 * @return 排序集合
	 */
	public abstract ArrayList<Order> doselectsort(User u);
	
	/**
	 * 这是一个将订单删除的方法
	 * @param m  管理员
	 * @param o 订单
	 * @return 是否删除成功
	 */
	public abstract boolean dodelect(Manager m, Order o);
}
