
package cn.kangz.dao;

import java.util.ArrayList;

import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Shop_cart;
import cn.kangz.pojo.User;
/**
 * ����һ�����ﳵ�Ĳ����Ľӿ�
 * @author kz
 *
 */
public interface Shop_cartDao {
	/**
	 *  * ����һ����ͼ����ӵ����ﳵ�ķ���
	 * @param bͼ�������
	 * @param u �û�
	 * @param num  ��ӵ�����
	 * @return �Ƿ���ӳɹ�
	 */
	public abstract boolean doinsert(Book_info b,User u,int num);
	/**
	 * ���ǽ����ﳵ��ͼ��ɾ���ķ���
	 * @param s ���ﳵ����
	 * @param u �û�
	 * @return ɾ���Ƿ�ɹ�
	 */
	public abstract boolean dodelete(Shop_cart s,User u);
	/**
	 * ����һ�������ڹ��ﳵ�����������ķ���
	 * @param num ���ӵ�����
	 * @param u �û�
	 * @return �Ƿ����ӳɹ�
	 */
	public abstract boolean doupdate(Shop_cart s,User u,int num);
	/**
	 * ���ǲ��ҹ��ﳵ��ͼ�鷽��
	 * @param u �û�
	 * @return ���ﳵ�ļ���
	 */
	public abstract ArrayList<Shop_cart> doselectall(User u);
	/**
	 * ����һ���ڹ��ﳵ����ҵ�ͼ��ķ���
	 * @param b ͼ��
	 * @param u �û�
	 * @return �Ƿ���ҵ���ͼ��
	 */
	public abstract Shop_cart doselect(Book_info b,User u);
}
