package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cn.kangz.dao.Book_infoDao;
import cn.kangz.dao.Shop_cartDao;
import cn.kangz.dao.UserDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.Book_infoDaoImpl;
import cn.kangz.impl.Shop_cartDaoImpl;
import cn.kangz.impl.UserDaoImpl;
import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Shop_cart;
import cn.kangz.pojo.User;
import cn.kangz.uitl.Music;
import java.awt.Toolkit;

public class Shopping {

	private JFrame frame;
	
	private JTable table;
	static Object[][] obj;
	static DefaultTableModel dtm = null;
	static JLabel data;
	private static int curentPageIndex = 1; // ��ǰҳ��
	private int countPerpage = 50; // ÿҳ��ʾ����
	private int pageCount; // ��ҳ��
	private int recordCount; // �ܼ�¼����
	static ArrayList<Book_info> ALLlist = new ArrayList<Book_info>();
	 static Book_info big= new Book_info();
	static User u = new User("test","1234");
	private static Shopping s;
	private static Userupdate dialogu = null;
	//ÿ��ֻ�й��������ע��������оͲ��ٴ������� ֻ����һ���������
	public static synchronized Shopping getInstance(User u) {
			if(s==null) {
				s= new Shopping(u);
			}
			return s;
		}
	
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Shopping window = new Shopping();
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
	public Shopping(User u) {
		initialize(u);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u) {
		Music m = new Music();
		m.start();
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
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Shopping.class.getResource("/pictrue/icon-shouye.png")));
		frame.setTitle("���");
		frame.setBounds(100, 100, 821, 746);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		 data = new JLabel();
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu search = new JMenu("��ѯ");
		search.setIcon(new ImageIcon(Shopping.class.getResource("/pictrue/search.png")));
		menuBar.add(search);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("���");
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������ݿ�
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				Book_infoDao bd = new Book_infoDaoImpl(conn);
				
				String inputDialog = JOptionPane.showInputDialog(null, "��������Ҫ���ҵı��", "8888");//Ĭ��8888
				if(inputDialog != null) {
					Book_info bi = new Book_info();
				
				bi.setBook_id(inputDialog);
				 ArrayList<Book_info> doselectlike = bd.doselectlike(bi, false);
				  printable(doselectlike);
				//System.out.println(inputDialog);
				}
				
				dc.close();
			}
		});
		search.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("����");
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������ݿ�
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				Book_infoDao bd = new Book_infoDaoImpl(conn);
				
				String inputDialog = JOptionPane.showInputDialog(null, "��������Ҫ���ҵ�����", "java");//Ĭ��java
				if(inputDialog != null ) {
					Book_info bi = new Book_info();
				bi.setBook_name(inputDialog);
				
				 ArrayList<Book_info> doselectlike = bd.doselectlike(bi, true);
				  printable(doselectlike);
				//System.out.println(inputDialog);
				}
				
				dc.close();
			}
			
		});
		
		search.add(mntmNewMenuItem_5);
		//���빺�ﳵ
		JButton btnNewButton = new JButton();
		btnNewButton.setToolTipText("\u8D2D\u4E70");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������ݿ�
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				Shop_cartDao sd = new Shop_cartDaoImpl(conn);
				
				if(big.getBook_name() !=null ) {
				String inputDialog = JOptionPane.showInputDialog(null, "ͼ������"+big.getBook_name()+"  ��������빺�ﳵ������", "1");  //Ĭ��һ��
				
				Shop_cart doselect = sd.doselect(big, u);
				if(inputDialog != null) {
					if(!(big.getBook_id().equals(doselect.getBook_id()))){//���ﳵû�е����
						if(big.getBook_name()!=null) {					
							boolean doinsert = sd.doinsert(big, u,Integer.parseInt(inputDialog.trim()));
							if(doinsert) {
								JOptionPane.showMessageDialog(null, "��ӳɹ���");
							}else {
								JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
							}
						}else {
							JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�����ͼ�飡");
						}
					}else {//���ǹ����Ѿ����˵����
						boolean doupdate = sd.doupdate(doselect, u,Integer.parseInt(inputDialog.trim())+Integer.parseInt(doselect.getOrder_sum()));
						if(doupdate) {
							JOptionPane.showMessageDialog(null, "��ӳɹ���");
						}else {
							JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
						}
					}
					}
				}
				
				dc.close();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Shopping.class.getResource("/pictrue/cart_empty.png")));
		menuBar.add(btnNewButton);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		menuBar.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu(u.getUsername());
		mnNewMenu_1.setIcon(new ImageIcon(Shopping.class.getResource("/pictrue/sub_account.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("�ҵ�");
		mnNewMenu_2.setIcon(new ImageIcon(Shopping.class.getResource("/pictrue/user.png")));
		mnNewMenu_1.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("������Ϣ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������ݿ�
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				UserDao ud= new UserDaoImpl(conn);
				User doselect = ud.doselect(u.getUsername());
				
				JOptionPane.showMessageDialog(null, "�˻���"+doselect.getUsername()+"\r\n"+"���룺"+doselect.getPassword()+"\r\n"+"��ʵ������"
				+doselect.getName()+"\r\n"+"�绰���룺"+doselect.getIphonenumber()+"\r\n"+"��ַ��"+doselect.getAddress());
				dbc.close();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("�޸���Ϣ");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������ݿ�
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				UserDao ud= new UserDaoImpl(conn);
				User doselect = ud.doselect(u.getUsername());
				
				dialogu=Userupdate.getInstance(doselect);
				dialogu.setVisible(true);//��ʾ����
				dialogu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//��������˳�
				
				dbc.close();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_10);
		//��ʾ���ﳵ
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("���ﳵ");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Shopping.class.getResource("/pictrue/cart_empty.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������ݿ�
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				UserDao ud= new UserDaoImpl(conn);
				User doselect = ud.doselect(u.getUsername());
				if(doselect != null) {
					CartJDialog frame = new CartJDialog(doselect);
					frame.setVisible(true);
				}
				
				dbc.close();
				 
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		//��ʾ����
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("�ҵĶ���");
		mntmNewMenuItem_3.setIcon(new ImageIcon(Shopping.class.getResource("/pictrue/order.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ordershow os = new Ordershow(u);
				os.setVisible(true);//��ʾ����
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("�˳�");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_11.setIcon(new ImageIcon(Shopping.class.getResource("/pictrue/close_filled.png")));
		mnNewMenu_1.add(mntmNewMenuItem_11);
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);//���������ʾ
		

			JPanel panel_1 = new JPanel();
			frame.getContentPane().add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(new BorderLayout(0, 0));
		
			table = new JTable();
			table.setRowHeight(30); 
			
			
			table.getTableHeader().setReorderingAllowed(false);//�����û��������������еĿ��
			table.getTableHeader().setResizingAllowed(false);//�������û������϶��еĿ��
			
			table.setBounds(0, 0, 1, 1);
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
	               //System.out.println(big);
	               }
	             }
			});
			if(curentPageIndex==1) {
			ArrayList<Book_info> select = select();
			printable(select);
			}
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		//���ù�������λ�� ��ֱ����ʾ��ˮƽ��ȡ��
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				
				
		panel_1.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		JToolBar toolBar = new JToolBar();
		panel_3.add(toolBar);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("��ͣ");
		toolBar.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.suspend();
			}
			
		});
		
		btnNewButton_1.setIcon(new ImageIcon(Shopping.class.getResource("/pictrue/play11.png")));
		
		toolBar.addSeparator(new Dimension(20,35));
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("����");
		toolBar.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.resume();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Shopping.class.getResource("/pictrue/play.png")));
	
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
				
		//��һҳ
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ArrayList<Book_info> previousPage =previousPage();
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
				init(u);
				printable(select());
				
			}
		});
		refresh.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/refresh.png")));
		panel_2.add(refresh);
		//��һҳ
		JButton next = new JButton("");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						ArrayList<Book_info> nextPage = nextPage();
				       printable(nextPage);
	 
			}
		});
		next.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/page_turning_right.png")));
		panel_2.add(next);
	
		data.setText("�ܹ�"+ALLlist.size()+"��¼|��ǰ��"+curentPageIndex+"ҳ|��"+pageCount+"ҳ");
		panel_2.add(data);

		
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
//				for(int row = 0;row<littlelist.size();row++)    //�������     
//				{ 
//				    Vector rowV = new Vector();        		 
//				    Book_info b= (Book_info) littlelist.get(row);
//				    rowV.add(new Boolean(false));
//					rowV.add(b.getBook_id());  //����   
//					rowV.add(b.getBook_name()); 
//					rowV.add(b.getBook_auther()); 
//					rowV.add(b.getBook_price()); 
//					rowV.add(b.getBook_type()); 
//					rowV.add(b.getBook_introdution()); 
//					
//				dtm.addRow(rowV);    
//				}
//				((DefaultTableModel) table.getModel()).getDataVector().clear();   //����������
//				((DefaultTableModel) table.getModel()).fireTableDataChanged();//֪ͨģ�͸���
//				table.updateUI();//ˢ�±�� 
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
			private void init(User u) {
				
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
