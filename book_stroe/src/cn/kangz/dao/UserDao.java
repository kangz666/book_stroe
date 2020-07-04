
package cn.kangz.dao;

import cn.kangz.pojo.User;

/**
 * 这是一个实现用户登录和注册的接口
 * @author kz
 *
 */
public interface UserDao {
	/**
	 * 这是一个登录的抽象方法 
	 * 
	 * @return true= 登录成功 false = 失败
	 * @param 传入用户的用户名和密码
	 */
	public abstract boolean login(User u);
	/**
	 * 这是一个注册的抽象方法
	 * @return true= 注册成功 false = 失败
	 */
	public abstract boolean resgis(User u)throws Exception;
	/**
	 * 找回密码
	 * @param username 输入账号 
	 * @param iphonenumber 输入手机号
	 * @return  该用户的所有信息
	 */
	public abstract User forget(String username,String iphonenumber);
	/**
	 * 这是一个查找账户是否已存在的抽象方法
	 * @param u 用户对象
	 * @return true = 查找到 ，false = 未找到
	 */
	public abstract boolean iscontain(User u);
	/**
	 * z这是一个按照用户名查找的方法
	 * @param username 用户名
	 * @return 查找到的用户对象
	 */
	public abstract User doselect(String username);
	/**
	 * 这是一个用户自己修改自己的相关信息的方法
	 * @param u 修改的对象
	 * @return  是否修改成功
	 */
	public abstract boolean update(User u);
}
