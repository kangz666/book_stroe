package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cn.kangz.dao.OrderDao;
import cn.kangz.dao.RecordDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.OrderDaoImpl;
import cn.kangz.impl.RecordDaoImpl;
import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Manager;
import cn.kangz.pojo.Record;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Toolkit;

public class Recordview {

	private JFrame frmLishijil;
	private static JTable table;
	static JLabel data;
	static Object[][] obj;
	static DefaultTableModel dtm = null;
	private static int curentPageIndex = 1; // ��ǰҳ��
	private int countPerpage = 20; // ÿҳ��ʾ����
	private int pageCount; // ��ҳ��
	private int recordCount; // �ܼ�¼����
	static ArrayList<Record> ALLlist = new ArrayList<Record>();
	 static Record big= new Record();
	 
//	 //Manager m=new Manager("abc123","8888");
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Recordview window = new Recordview(new Manager("abc123","8888"));
//					window.frmLishijil.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Recordview(Manager m) {
		initialize(m);
		frmLishijil.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Manager m) {
		
		// ��ϵͳ���
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmLishijil = new JFrame();
		frmLishijil.setIconImage(Toolkit.getDefaultToolkit().getImage(Recordview.class.getResource("/pictrue/icon-dangdifill.png")));
		frmLishijil.setTitle("��ʷ��¼");
		frmLishijil.setBounds(100, 100, 626, 578);
		frmLishijil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		frmLishijil.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		data = new JLabel();
		init(m);
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//�õ�ѡ�е����е�����ֵ
	               int r= table.getSelectedRow();
	               int c= table.getSelectedColumn();
	               if(r==-1&&c==-1) {
	            	   JOptionPane.showMessageDialog(null,"�����ǰ��Ч");
	               }else {
	            	   Object[][] value = new Object[r+1][5];
	               for(int i =r;i<r+1;i++) {
	            	   for(int j=0;j<5;j++) {
	            		    value[i][j]= table.getValueAt(i, j);
	            	   }
	               }
	               
	               for(int i =r;i<r+1;i++) { 
	            	   
	            	  big.setManager_id(value[i][0].toString());
	            	  big.setOrder_id(value[i][1].toString());
	            	  big.setType( value[i][2].toString());
	            	  big.setDate(value[i][3].toString());//�ַ���תΪdouble
	            	  big.setMoney( value[i][4].toString());
	            	 
	               }
	              // System.out.println(big);
	               }
	               
			}
		});
		
		table.setRowHeight(30); 
		
		
		table.getTableHeader().setReorderingAllowed(false);//�����û��������������еĿ��
		table.getTableHeader().setResizingAllowed(false);//�������û������϶��еĿ��
		
		if(curentPageIndex==1) {
			ArrayList<Record> select = select();
			
			printable(select);
			}
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		//���ù�������λ�� ��ֱ����ʾ��ˮƽ��ȡ��
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);			
		
		
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		frmLishijil.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("ɾ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecordDao rd =new RecordDaoImpl();
				if(big != null) {
				Iterator<Record> it = ALLlist.iterator();
				while(it.hasNext()) {
					if(big.getOrder_id().equals(it.next().getOrder_id())) { //ѡ�еļ�¼�Ƿ�ͼ������
						it.remove();
					}
				}
				boolean b = rd.inputrecordover(m, ALLlist);
				if(b) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					init(m);
					printable(ALLlist);
				} else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
				}
			}else {
				JOptionPane.showMessageDialog(null, "û��ѡ���¼��");
			}
				
			}
			
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�޸�");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(big != null) {
				String dialog = JOptionPane.showInputDialog(null,"�������޸ĵ�����",big.getType());
				if(dialog != null) {
					String dialog2 = JOptionPane.showInputDialog(null,"�������޸ĵĽ��",big.getMoney());
					if(dialog2 != null) {
						Record r = new Record();
						r.setManager_id(m.getManager_id());
						r.setOrder_id(big.getOrder_id());
						r.setType(dialog.trim());
						r.setDate(big.getDate());
						r.setMoney(dialog2.trim());
						
						for(Record R : ALLlist) {
							if(R.getOrder_id().equals(r.getOrder_id())) {
								Collections.replaceAll(ALLlist, R, r);
								break;
							}
						}
					}
					RecordDao rd =new RecordDaoImpl();
					boolean b = rd.inputrecordover(m, ALLlist);
					if(b) {
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
						init(m);
						printable(ALLlist);
					} else {
						JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
					}
				}
				
			}
			}
				
		});
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		frmLishijil.getContentPane().add(panel_2, BorderLayout.SOUTH);

		
		//��һҳ
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					ArrayList<Record> previousPage =previousPage();
					
					printable(previousPage);
			}
		});
		back.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/page_turning_left.png")));
		panel_2.add(back);
		//ˢ��
		JButton refresh = new JButton("");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curentPageIndex=1;
				init(m);
				frmLishijil.setVisible(false);
				initialize(m);
				
			}
		});
		refresh.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/refresh.png")));
		panel_2.add(refresh);
		//��һҳ
		JButton next = new JButton("");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				       printable(nextPage());
	 
			}
		});
		next.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/page_turning_right.png")));
		panel_2.add(next);
		//System.out.println(curentPageIndex);
		data.setText("�ܹ�"+ALLlist.size()+"��¼|��ǰ��"+curentPageIndex+"ҳ|��"+pageCount+"ҳ");
		panel_2.add(data);
	}
	// ��һҳ
		public ArrayList<Record> nextPage() {

				if (curentPageIndex < pageCount) {
					curentPageIndex++;
					 //System.out.println("��ǰҳ:"+curentPageIndex);
				} else {
					String message = "��ǰ�Ѿ������һҳ��";
					JOptionPane.showMessageDialog(null, message);
				}

				return select();
			}

			// ��һҳ
			public ArrayList<Record> previousPage() {
				
				if (curentPageIndex > 1) {
					curentPageIndex--;
					// System.out.println("��ǰҳ:"+curentPageIndex);
				} else {
					String message = "��ǰ�ǵ�һҳ��";
					JOptionPane.showMessageDialog(null, message);
				}

				return select();
			}

			/**
			 * ����һ�����󼯺ϰ���ÿ��ҳ����������ֵ�С������
			 * 
			 * @return ҳ�뼯��
			 */
			public ArrayList<Record> select() {
				
				ArrayList<Record> list =new ArrayList<Record>();
				// ����ܼ��ϵĴ�С
				recordCount = ALLlist.size();
				// ��ʼ��ֵ�� ����ǰ��ҳ��-1��*ÿҳ����������������iС�ڴ󼯺ϵĴ�С����С�ڵ�ǰҳ����*ÿһҳ������
				for (int i = (curentPageIndex - 1) * countPerpage; i < curentPageIndex * countPerpage && i < recordCount; i++) {
					// ��ӵ�ÿһҳ��С��������
					list.add(ALLlist.get(i));
					
				}
				Collections.sort(list, new Comparator<Record>(){

					@Override
					public int compare(Record o1, Record o2) {

						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
						Date date1 = null;
						Date date2 = null;
								try {
									date1=sdf.parse(o1.getDate());
									date2=sdf.parse(o2.getDate());
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						return -(date1.compareTo(date2));
					}
					
	           });
				
//				for(Record r: list ) {
//					System.out.println(r);
//				}
//				

				return list;
			}

			/**
			 * ����Ǵ�ӡ���ķ���
			 * 
			 * @param littlelist ҳ�뼯��
			 */
			public static void printable(ArrayList<Record> littlelist) {
				((DefaultTableModel) table.getModel()).getDataVector().clear(); // ����������
				((DefaultTableModel) table.getModel()).fireTableDataChanged();// ֪ͨģ�͸���
				table.updateUI();// ˢ�±��
				
				String[] str = new String[] { "����Ա", "������", "��������", "ʱ��", "���"};
				Object[][] obj = new Object[littlelist.size()][5];

				/*private String Manager_id;  //����Ա
					private String order_id;   //������
					private String type;     //��������
					private String date;     //����ʱ��
					private String money;    ///�������*/
				
				// ������
				for (int i = 0; i < littlelist.size(); i++) {
					if (i < littlelist.size()) {
						Record r = littlelist.get(i);

						obj[i][0] = r.getManager_id();
						obj[i][1] = r.getOrder_id();
						obj[i][2] = r.getType();
						obj[i][3] = r.getDate();
						obj[i][4] = r.getMoney();
						
					}
				}
				dtm = new DefaultTableModel(obj, str);
				// ���ñ�����ʽ
				table.setModel(dtm);
				table.getColumnModel().getColumn(0).setPreferredWidth(50);
				table.getColumnModel().getColumn(1).setPreferredWidth(25);
				table.getColumnModel().getColumn(2).setPreferredWidth(25);
				table.getColumnModel().getColumn(3).setPreferredWidth(25);
				table.getColumnModel().getColumn(4).setPreferredWidth(25);
				

				// ���ñ�ͷ���ݾ���
				((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

				// ���õ�Ԫ�����ݾ���
				DefaultTableCellRenderer render = new DefaultTableCellRenderer();
				render.setHorizontalAlignment(SwingConstants.CENTER);
				// ���þ���
				table.getTableHeader().getColumnModel().getColumn(0).setCellRenderer(render);
				table.getTableHeader().getColumnModel().getColumn(1).setCellRenderer(render);
				table.getTableHeader().getColumnModel().getColumn(2).setCellRenderer(render);
				table.getTableHeader().getColumnModel().getColumn(3).setCellRenderer(render);
				table.getTableHeader().getColumnModel().getColumn(4).setCellRenderer(render);
				

			}
			private void init(Manager m) {
				
				RecordDao rd = new RecordDaoImpl();
				this.ALLlist = rd.ouputList(m);
				// System.out.println(ALLlist);
				//data.setText("�ܹ�"+ALLlist.size()+"��¼|��ǰ��"+curentPageIndex+"ҳ|��"+pageCount+"ҳ");
				// ������ҳ��
				if (ALLlist.size() % countPerpage == 0) {
					pageCount = ALLlist.size() / countPerpage;
				} else {
					pageCount = (ALLlist.size() / countPerpage) + 1;
				}
				Collections.sort(ALLlist, new Comparator<Record>(){

					@Override
					public int compare(Record o1, Record o2) {

						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
						Date date1 = null;
						Date date2 = null;
								try {
									date1=sdf.parse(o1.getDate());
									date2=sdf.parse(o2.getDate());
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						return -(date1.compareTo(date2));
					}
					
	           });
			}
}
