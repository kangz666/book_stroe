
package cn.kangz.dao;

import cn.kangz.pojo.User;

/**
 * ����һ��ʵ���û���¼��ע��Ľӿ�
 * @author kz
 *
 */
public interface UserDao {
	/**
	 * ����һ����¼�ĳ��󷽷� 
	 * 
	 * @return true= ��¼�ɹ� false = ʧ��
	 * @param �����û����û���������
	 */
	public abstract boolean login(User u);
	/**
	 * ����һ��ע��ĳ��󷽷�
	 * @return true= ע��ɹ� false = ʧ��
	 */
	public abstract boolean resgis(User u)throws Exception;
	/**
	 * �һ�����
	 * @param username �����˺� 
	 * @param iphonenumber �����ֻ���
	 * @return  ���û���������Ϣ
	 */
	public abstract User forget(String username,String iphonenumber);
	/**
	 * ����һ�������˻��Ƿ��Ѵ��ڵĳ��󷽷�
	 * @param u �û�����
	 * @return true = ���ҵ� ��false = δ�ҵ�
	 */
	public abstract boolean iscontain(User u);
	/**
	 * z����һ�������û������ҵķ���
	 * @param username �û���
	 * @return ���ҵ����û�����
	 */
	public abstract User doselect(String username);
	/**
	 * ����һ���û��Լ��޸��Լ��������Ϣ�ķ���
	 * @param u �޸ĵĶ���
	 * @return  �Ƿ��޸ĳɹ�
	 */
	public abstract boolean update(User u);
}
