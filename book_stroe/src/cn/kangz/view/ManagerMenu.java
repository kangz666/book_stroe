package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

import cn.kangz.dao.Book_infoDao;
import cn.kangz.dao.OrderDao;
import cn.kangz.dao.RecordDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.Book_infoDaoImpl;
import cn.kangz.impl.OrderDaoImpl;
import cn.kangz.impl.RecordDaoImpl;
import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Manager;

public class ManagerMenu {

	private JFrame frame;
	private JTable table;
	static Object[][] obj;
	static JLabel data;
	private static AddJDialog dialoga; //���ͼ�鴰��
	private static RigJDialog dialogs; //�޸�ͼ�鴰��
	private static RigMaJDialog dialogrm; //�޸Ĺ���Ա��Ϣ
	DefaultTableModel dtm = null;
	private static int curentPageIndex = 1; // ��ǰҳ��
	private int countPerpage = 50; // ÿҳ��ʾ����
	private int pageCount; // ��ҳ��
	private int recordCount; // �ܼ�¼����
	static ArrayList<Book_info> ALLlist = new ArrayList<Book_info>();
	Book_info big= new Book_info();
	private static ManagerMenu mm ;
	
	//ÿ��ֻ�й��������ע��������оͲ��ٴ������� ֻ����һ���������
	public static synchronized ManagerMenu getInstance(Manager m) {
			if(mm==null) {
				mm= new ManagerMenu(m);
			}
			return mm;
		}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManagerMenu window = new ManagerMenu();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	// ��ʼ���飬�������ʱ�������Զ�����
	{
		
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		Book_infoDao bd = new Book_infoDaoImpl(conn);
		this.ALLlist = bd.doselectall();
		// System.out.println(ALLlist);
		dbc.close();
		// ������ҳ��
		if (ALLlist.size() % countPerpage == 0) {
			this.pageCount = ALLlist.size() / countPerpage;
		} else {
			this.pageCount = (ALLlist.size() / countPerpage) + 1;
		}

	}

	/**
	 * Create the application.
	 */

	public ManagerMenu(Manager m) {
		initialize(m);
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
		RecordDao rd =new RecordDaoImpl();
		rd.newfile(m);
		frame = new JFrame();
		frame.setTitle("ͼ�����");
		frame.setBounds(100, 100, 905, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);//���������ʾ
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {//������굥��ʱ��Ӧ
			
                //�õ�ѡ�е����е�����ֵ
               int r= table.getSelectedRow();
               int c= table.getSelectedColumn();
               if(r==-1&&c==-1) {
            	   JOptionPane.showMessageDialog(null,"�����ǰ��Ч");
               }else {
            	   Object[][] value = new Object[r+1][6];
               for(int i =r;i<r+1;i++) {
            	   for(int j=0;j<6;j++) {
            		    value[i][j]= table.getValueAt(i, j);
            	   }
               }
               for(int i =r;i<r+1;i++) { 
            	  big.setBook_id(value[i][0].toString());
            	  big.setBook_name(value[i][1].toString());
            	  big.setBook_auther( value[i][2].toString());
            	  big.setBook_price(Double.parseDouble(value[i][3].toString()) );//�ַ���תΪdouble
            	  big.setBook_type( value[i][4].toString());
            	  big.setBook_introdution( value[i][5].toString());
               }
               }
               
             }
		});
		
		//dtm = new DefaultTableModel(str,0);
		table.setRowHeight(30); 

		table.getTableHeader().setReorderingAllowed(false);//�����û��������������еĿ��
		table.getTableHeader().setResizingAllowed(false);//�������û������϶��еĿ��
		table.setBounds(0, 0, 1, 1);
		
		if(curentPageIndex==1) {
		ArrayList<Book_info> select = select();
		printable(select);
		}
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 2, 2);
		
		//���ù�������λ�� ��ֱ����ʾ��ˮƽ��ȡ��
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu menu = new JMenu("ͼ�����");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("����");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialoga=AddJDialog.getInstance();
				dialoga.setVisible(true);//��ʾ����
				dialoga.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//��������˳�
				
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("�޸�");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dialogs=RigJDialog.getInstance(big);
				dialogs.setVisible(true);//��ʾ����
				dialogs.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//��������˳�
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_4_2 = new JMenuItem("ɾ��");
		menuItem_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	//�������ݿ�
					DatabaseConnection dc = new DatabaseConnection();
					Connection conn = dc.getConnection();
					Book_infoDao bd = new Book_infoDaoImpl(conn);
					boolean dodelete = bd.dodelete(big.getBook_id());
					if(dodelete) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					}else {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
					}
					dc.close(); //�ر���Դ
			}
		});
		menu.add(menuItem_4_2);
		
		JMenuItem menuItem_5 = new JMenuItem("��Ų�ѯ");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������ݿ�
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				Book_infoDao bd = new Book_infoDaoImpl(conn);
				
				String inputDialog = JOptionPane.showInputDialog(null, "��������Ҫ���ҵı��", "8888");//Ĭ��8888
				Book_info bi = new Book_info();
				
				bi.setBook_id(inputDialog);
				 ArrayList<Book_info> doselectlike = bd.doselectlike(bi, false);
				  printable(doselectlike);
				//System.out.println(inputDialog);
				dc.close();
			}
		});
		menu.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("������ѯ");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������ݿ�
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				Book_infoDao bd = new Book_infoDaoImpl(conn);
				
				String inputDialog = JOptionPane.showInputDialog(null, "��������Ҫ���ҵ�����", "java");//Ĭ��java
				
				Book_info bi = new Book_info();
				bi.setBook_name(inputDialog);
				
				 ArrayList<Book_info> doselectlike = bd.doselectlike(bi, true);
				  printable(doselectlike);
				//System.out.println(inputDialog);
				dc.close();
			}
		});
		menu.add(menuItem_6);
		
		JMenu menu_1 = new JMenu("����");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_4 = new JMenuItem("�鿴����");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindOrder fo = new FindOrder(m);
			}
		});
		menu_1.add(menuItem_4);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("�˿��");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefundJDialog rjd = new RefundJDialog(m);
			}
		});
		menu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("����");
		menu_1.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("δ����");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UntreatedOrder uo = new UntreatedOrder(m);
			}
		});
		
//		JMenuItem mntmShanchu = new JMenuItem("ɾ��");
//		mntmShanchu.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//�������ݿ�
//				DatabaseConnection dc = new DatabaseConnection();
//				Connection conn = dc.getConnection();
//				OrderDao od = new OrderDaoImpl(conn);
//				od.dodelect(m, big);
//			}
//		});
//		mnNewMenu_2.add(mntmShanchu);
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_3 = new JMenu("��¼");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem menuItem_7 = new JMenuItem("��ʷ��¼");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recordview  rv = new Recordview(m);
			}
		});
		mnNewMenu_3.add(menuItem_7);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		menuBar.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("����Ա:"+m.getManager_id());
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem_2 = new JMenuItem("�˳�");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("�޸���Ϣ");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogrm=RigMaJDialog.getInstance(m);
				dialogrm.setVisible(true);//��ʾ����
				dialogrm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//��������˳�	
			}
		});
		mnNewMenu.add(menuItem_3);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		 data = new JLabel();
		
		
		//��һҳ
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ArrayList<Book_info> previousPage =previousPage();
					printable(previousPage);
			}
		});
		back.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/page_turning_left.png")));
		panel_1.add(back);
		//ˢ��
		JButton refresh = new JButton("");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init();
				curentPageIndex=1;
				printable(select());
				
			}
		});
		refresh.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/refresh.png")));
		panel_1.add(refresh);
		//��һҳ
		JButton next = new JButton("");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						ArrayList<Book_info> nextPage = nextPage();
				       printable(nextPage);
	 
			}
		});
		next.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/page_turning_right.png")));
		panel_1.add(next);
		
		data.setText("�ܹ�"+ALLlist.size()+"��¼|��ǰ��"+curentPageIndex+"ҳ|��"+pageCount+"ҳ");
		panel_1.add(data);
		
		
	}

	// ��һҳ
	public ArrayList<Book_info> nextPage() {

		if (curentPageIndex < pageCount) {
			curentPageIndex++;
			data.setText("�ܹ�"+ALLlist.size()+"��¼|��ǰ��"+curentPageIndex+"ҳ|��"+pageCount+"ҳ");
			// System.out.println("��ǰҳ:"+curentPageIndex);
		} else {
			String message = "��ǰ�Ѿ������һҳ��";
			JOptionPane.showMessageDialog(null, message);
		}

		return select();
	}

	// ��һҳ
	public ArrayList<Book_info> previousPage() {
		if (curentPageIndex > 1) {
			curentPageIndex--;
			data.setText("�ܹ�"+ALLlist.size()+"��¼|��ǰ��"+curentPageIndex+"ҳ|��"+pageCount+"ҳ");
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
	public ArrayList<Book_info> select() {
		ArrayList<Book_info> littlelist = new ArrayList<Book_info>();
		// ����ܼ��ϵĴ�С
		recordCount = ALLlist.size();
		// ��ʼ��ֵ�� ����ǰ��ҳ��-1��*ÿҳ����������������iС�ڴ󼯺ϵĴ�С����С�ڵ�ǰҳ����*ÿһҳ������
		for (int i = (curentPageIndex - 1) * countPerpage; i < curentPageIndex * countPerpage && i < recordCount; i++) {
			// ��ӵ�ÿһҳ��С��������
			littlelist.add(ALLlist.get(i));
		}
		Collections.sort(littlelist, new Comparator<Book_info>() {

			@Override
			public int compare(Book_info o1, Book_info o2) {
				if(o1.getBook_price()>o2.getBook_price()) {
					return 1;
				}
				else if(o1.getBook_price()<o2.getBook_price()) {
					return -1;
				}else {
					return 0 ;
				}
			}
		});
		return littlelist;
	}

	/**
	 * ����Ǵ�ӡ���ķ���
	 * 
	 * @param littlelist ͼ�����ҳ�뼯��
	 */
	public void printable(ArrayList<Book_info> littlelist) {
		((DefaultTableModel) table.getModel()).getDataVector().clear(); // ����������
		((DefaultTableModel) table.getModel()).fireTableDataChanged();// ֪ͨģ�͸���
		table.updateUI();// ˢ�±��
		// dtm.setRowCount(0);
		// ((DefaultTableModel)table.getModel()).getDataVector().clear();
//		for(int row = 0;row<littlelist.size();row++)    //�������     
//		{ 
//		    Vector rowV = new Vector();        		 
//		    Book_info b= (Book_info) littlelist.get(row);
//		    rowV.add(new Boolean(false));
//			rowV.add(b.getBook_id());  //����   
//			rowV.add(b.getBook_name()); 
//			rowV.add(b.getBook_auther()); 
//			rowV.add(b.getBook_price()); 
//			rowV.add(b.getBook_type()); 
//			rowV.add(b.getBook_introdution()); 
//			
//		dtm.addRow(rowV);    
//		}
//		((DefaultTableModel) table.getModel()).getDataVector().clear();   //����������
//		((DefaultTableModel) table.getModel()).fireTableDataChanged();//֪ͨģ�͸���
//		table.updateUI();//ˢ�±�� 
		String[] str = new String[] { "���", "����", "����", "�۸�", "����", "���" };
		Object[][] obj = new Object[littlelist.size()][6];

		// ������
		for (int i = 0; i < littlelist.size(); i++) {
			if (i < littlelist.size()) {
				Book_info b = littlelist.get(i);

				obj[i][0] = b.getBook_id();
				obj[i][1] = b.getBook_name();
				obj[i][2] = b.getBook_auther();
				obj[i][3] = b.getBook_price();
				obj[i][4] = b.getBook_type();
				obj[i][5] = b.getBook_introdution();
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
		table.getColumnModel().getColumn(5).setPreferredWidth(100);

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
		table.getTableHeader().getColumnModel().getColumn(5).setCellRenderer(render);

	}
	private void init() {
		
		
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		Book_infoDao bd = new Book_infoDaoImpl(conn);
		this.ALLlist = bd.doselectall();
		// System.out.println(ALLlist);
		dbc.close();
		// ������ҳ��
		if (ALLlist.size() % countPerpage == 0) {
			this.pageCount = ALLlist.size() / countPerpage;
		} else {
			this.pageCount = (ALLlist.size() / countPerpage) + 1;
		}
	}

}
