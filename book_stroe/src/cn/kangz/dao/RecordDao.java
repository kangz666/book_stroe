
package cn.kangz.dao;

import java.util.ArrayList;

import cn.kangz.pojo.Manager;
import cn.kangz.pojo.Record;
/**
 * ����һ���Լ�¼�Ĳ����Ľӿ�
 * @author kz
 *
 */
public interface RecordDao {
	/**
	 * ����һ��������Ա�Ĳ��������ļ���
	 * @param m  ����Ա
	 * @param r  ����
	 * @return �Ƿ����ɹ�
	 */
	public abstract  boolean inputrecord(Manager m,Record r);
	/**
	 * ����һ��������Ա�ļ�¼д�뼯�ϵķ���
	 * @param m ����Ա
	 * @return ��¼����
	 */
	public abstract ArrayList<Record> ouputList(Manager m);
	/**
	 * ����һ��������д���ļ��ķ���
	 * @param list ��¼����
	 * @return �Ƿ�ɹ�
	 */
	public abstract boolean inputrecordover(Manager m,ArrayList<Record> list);
	/**
	 * ����һ�����Թ���Ա�����ִ����ļ�
	 * @param m  ����Ա
	 * @return �Ƿ�ɹ�
	 */
	public abstract boolean newfile(Manager m);
 }
