
package cn.kangz.dao;

import cn.kangz.pojo.Manager;
/**
 * ����һ������Ա�Ľӿ�
 * @author kz
 *
 */

public interface ManagerDao {
	/**
	 * ����һ������Ա��½�ķ���
	 * @param m ����Ա����
	 * @return �Ƿ��¼�ɹ�
	 */
	public abstract boolean dologin(Manager m);
	/**
	 * ����һ������Ա�޸��Լ�����Ϣ�ķ���
	 * @param m ����Ա����
	 * @return �Ƿ�ɹ�
	 */
	public abstract boolean doupdate(Manager m);
}
