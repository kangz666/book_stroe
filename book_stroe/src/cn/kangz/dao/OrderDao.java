
package cn.kangz.dao;

import java.util.ArrayList;

import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Manager;
import cn.kangz.pojo.Order;
import cn.kangz.pojo.Shop_cart;
import cn.kangz.pojo.User;
/**
 * ����һ���Զ����Ĳ����Ľӿ�
 * @author kz
 *
 */
public interface OrderDao {
	/**
	 * ����һ���ύ����ͼ��ķ���
	 * @param o ���� 
	 * @return �Ƿ�ɹ�
	 */
	public abstract boolean doSubmit(Order o);
	/**
	 * ����һ���û��Լ��Ĳ��Ҷ����еĶ�������
	 * @param u �û�
	 * @return ����
	 */
	public abstract ArrayList<Order> douserselect(User u);
	/**
	 * ���ҹ���Ա�����˿�Ķ���
	 * @return ����
	 */
	public abstract ArrayList<Order> domanagerrefundselect();
	/**
	 * z����һ���޸��˿�ķ���
	 * @param o ����
	 * @param m ����Ա
	 * @param handle ����ʽ
	 * @return �Ƿ�ɹ�
	 */
	public boolean doUpdateorder(Order o, Manager m,String handle);
	/**
	 * ���ҹ���Աδ����Ķ���
	 * @return ����
	 */
	public abstract ArrayList<Order> domanagerfalseselect();
	/**
	 * �����û������ж���
	 * @return ����
	 */
	public abstract ArrayList<Order> domanagerallselect();
	/**
	 * ����һ������Ա�������ķ������޸Ĳ���
	 * @param o ����
	 * @param Manager_id ����Ա��
	 * @return  �Ƿ��޸ĳɹ�
	 */
	public abstract boolean doUpdate(Order o,String Manager_id);
	/**
	 * ����һ�������ռ۸�ķ���
	 * @param u �û�����
	 * @return ���򼯺�
	 */
	public abstract ArrayList<Order> doselectsort(User u);
	
	/**
	 * ����һ��������ɾ���ķ���
	 * @param m  ����Ա
	 * @param o ����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public abstract boolean dodelect(Manager m, Order o);
}
