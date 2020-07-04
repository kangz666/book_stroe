/**
 * ���ݽӿڰ�
 */
package cn.kangz.dao;

import java.util.ArrayList;

import cn.kangz.pojo.Book_info;
/**
 * ����һ����ͼ��Ĳ����Ľӿ�
 * @author kz
 *
 */
public interface Book_infoDao {
	/**
	 * ����һ���԰�ͼ��IDͼ����ҵķ���
	 * @param ͼ�����
	 * @return ���ҵ���ͼ��
	 */
	public abstract Book_info doselectid(String id);
	/**
	 * ����һ���԰�ͼ����ͼ����ҵķ���
	 * @param name ͼ�����
	 * @return ���ҵ���ͼ��
	 */
	public abstract Book_info doselectname(String name);
	/**
	 * ����һ����ͼ������޸ĵ�
	 * @param b ͼ�����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public abstract boolean doupdate(Book_info b);
	/**
	 * ����һ����ͼ����в���ķ���
	 * @param b ͼ�����
	 * @return �Ƿ����ɹ�
	 */
	public abstract boolean doinsert(Book_info b);
	/**
	 * ����һ����ͼ�����ɾ���Ĳ�������
	  * @param b ͼ�����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public abstract boolean dodelete(String id);
	/**
	 * ����һ�������ݿ��ȫ����ѯ�Ĳ����ķ���
	 * @return ͼ�鼯�϶���
	 */
	public abstract ArrayList<Book_info> doselectall();
	/**
	  *   ����һ���Ա�ź�������һ��ģ�����ҵĹ���
	 * @param b  ���ҵĶ���
	 * @param flag  false=����ţ�true=������
	 * @return
	 */
	public abstract ArrayList<Book_info> doselectlike(Book_info b,boolean flag);
	/**
	  * ����һ���Ա�źͼ۸����ߵ�һ����������ͽ��򣩵Ĺ���
	 * @param num   2  �۸�    3������
	 * @param flag   flag = false ���� =true ����
	 * @returnͼ�鼯��
	 */
	public abstract ArrayList<Book_info> doselectsort(int num,boolean flag);
}
