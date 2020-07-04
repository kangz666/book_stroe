
package cn.kangz.dao;

import cn.kangz.pojo.Manager;
/**
 * 这是一个管理员的接口
 * @author kz
 *
 */

public interface ManagerDao {
	/**
	 * 这是一个管理员登陆的方法
	 * @param m 管理员对象
	 * @return 是否登录成功
	 */
	public abstract boolean dologin(Manager m);
	/**
	 * 这是一个管理员修改自己的信息的方法
	 * @param m 管理员对象
	 * @return 是否成功
	 */
	public abstract boolean doupdate(Manager m);
}
