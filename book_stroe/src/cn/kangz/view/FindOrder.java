package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import cn.kangz.pojo.Manager;
import cn.kangz.pojo.Order;
import cn.kangz.pojo.Record;
import cn.kangz.pojo.User;
import java.awt.Toolkit;

public class FindOrder {

	private JFrame frame;
	private JTable table;
	static Object[][] obj;
	DefaultTableModel dtm = null;
	private static int curentPageIndex = 1; // ��ǰҳ��
	private int countPerpage = 20; // ÿҳ��ʾ����
	private int pageCount; // ��ҳ��
	private int recordCount; // �ܼ�¼����
	static ArrayList<Order> ALLlist = new ArrayList<Order>();
	 static Order big= new Order();
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FindOrder window = new FindOrder();
//					
//					//window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
////					window.frame.setVisible(true);
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
				OrderDao od = new OrderDaoImpl(conn);
				this.ALLlist = od.domanagerallselect();
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
	public FindOrder(Manager m) {
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
		frame = new JFrame();
		frame.setTitle("����");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FindOrder.class.getResource("/pictrue/order.png")));
		frame.setBounds(100, 100, 1083, 639);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {//������굥��ʱ��Ӧ
			
                //�õ�ѡ�е����е�����ֵ
               int r= table.getSelectedRow();
               int c= table.getSelectedColumn();
               if(r==-1&&c==-1) {
            	   JOptionPane.showMessageDialog(null,"�����ǰ��Ч");
               }else {
            	   Object[][] value = new Object[r+1][11];
               for(int i =r;i<r+1;i++) {
            	   for(int j=0;j<11;j++) {
            		    value[i][j]= table.getValueAt(i, j);
            	   }
               }
               /*private String order_id;  //������
   			private String book_id;
   			private String manager_id; //������
   			private String username;  //�û���
   			private String book_name;  //����
   			private String order_sum;  //ͼ������
   			private Date date;        //����ʱ��
   			private String name;  //��ʵ����
   			private String address;
   			private String phonenumber;
   			private double price;//�ܼ۸�
   			private String order_state; //����״̬
   			private String order_remark;//��ע*/
               for(int i =r;i<r+1;i++) { 
            	  big.setOrder_id(value[i][0].toString());
            	  big.setBook_id(value[i][1].toString());
            	  big.setUsername( value[i][2].toString());
            	  big.setBook_name(value[i][3].toString());
            	  big.setOrder_sum( value[i][4].toString());
            	  big.setPrice(Double.parseDouble(value[i][9].toString()));
               }
               }
               
             }
		});
		table.setRowHeight(30); 
		
		table.getTableHeader().setReorderingAllowed(false);//�����û��������������еĿ��
		table.getTableHeader().setResizingAllowed(false);//�������û������϶��еĿ��

		if(curentPageIndex==1) {
			ArrayList<Order> select = select();
			printable(select);
		}
		JScrollPane scrollPane = new JScrollPane(table);
		//���ù�������λ�� ��ֱ����ʾ��ˮƽ��ʾ
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		JLabel data = new JLabel();
		data.setText("�ܹ�"+ALLlist.size()+"��¼|��ǰ��"+curentPageIndex+"ҳ|��"+pageCount+"ҳ");
		panel_1.add(data);
		
		//��һҳ
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ArrayList<Order> previousPage =previousPage();
					printable(previousPage);
			}
		});
		back.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/page_turning_left.png")));
		panel_1.add(back);
		//ˢ��
		JButton refresh = new JButton("");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curentPageIndex=1;
				init();
				printable(select());
				
			}
		});
		refresh.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/refresh.png")));
		panel_1.add(refresh);
		//��һҳ
		JButton next = new JButton("");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						ArrayList<Order> nextPage = nextPage();
				       printable(nextPage);
	 
			}
		});
		next.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/page_turning_right.png")));
		panel_1.add(next);
		
		JButton btnNewButton = new JButton("��ѯ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dialog = JOptionPane.showInputDialog(null,"�������ѯ���û�����","�û���");
				if(dialog != null) {
					DatabaseConnection dbc = new DatabaseConnection();
					Connection conn = dbc.getConnection();
					OrderDao od = new OrderDaoImpl(conn);
					User u = new User();
					u.setUsername(dialog.trim());
					 ArrayList<Order> douserselect = od.douserselect(u);
					printable(douserselect);
					dbc.close();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(FindOrder.class.getResource("/pictrue/search.png")));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ɾ��");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������ݿ�
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				OrderDao od = new OrderDaoImpl(conn);
				if(big.getOrder_id() != null) {
					boolean dodelect = od.dodelect(m, big);
					if(dodelect) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						init();
						printable(select());
					}else {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
					}
				}
				//��¼
				RecordDao rd =new RecordDaoImpl();
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String stringdate = sdf.format(date);
				rd.inputrecord(m, new Record(m.getManager_id(),big.getOrder_id(),"ɾ������",stringdate,String.valueOf(big.getPrice())));
			}
		});
		panel_1.add(btnNewButton_1);
	}
	// ��һҳ
			public ArrayList<Order> nextPage() {

				if (curentPageIndex < pageCount) {
					curentPageIndex++;
					// System.out.println("��ǰҳ:"+curentPageIndex);
				} else {
					String message = "��ǰ�Ѿ������һҳ��";
					JOptionPane.showMessageDialog(null, message);
				}

				return select();
			}

			// ��һҳ
			public ArrayList<Order> previousPage() {
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
			public ArrayList<Order> select() {
				ArrayList<Order> littlelist = new ArrayList<Order>();
				// ����ܼ��ϵĴ�С
				recordCount = ALLlist.size();
				// ��ʼ��ֵ�� ����ǰ��ҳ��-1��*ÿҳ����������������iС�ڴ󼯺ϵĴ�С����С�ڵ�ǰҳ����*ÿһҳ������
				for (int i = (curentPageIndex - 1) * countPerpage; i < curentPageIndex * countPerpage && i < recordCount; i++) {
					// ��ӵ�ÿһҳ��С��������
					littlelist.add(ALLlist.get(i));
				}

				return littlelist;
			}

			/**
			 * ����Ǵ�ӡ���ķ���
			 * 
			 * @param littlelist ҳ�뼯��
			 */
			public void printable(ArrayList<Order> littlelist) {
				((DefaultTableModel) table.getModel()).getDataVector().clear(); // ����������
				((DefaultTableModel) table.getModel()).fireTableDataChanged();// ֪ͨģ�͸���
				table.updateUI();// ˢ�±��
				

				String[] str = new String[] { "������", "ͼ����","�û���", "ͼ������","ͼ������","����ʱ��","��ʵ����","��ַ","�绰����","���","����״̬","��ע"};
				Object[][] obj = new Object[littlelist.size()][12];

				/*private String order_id;  //������
				private String book_id;
				private String manager_id; //������
				private String username;  //�û���
				private String book_name;  //����
				private String order_sum;  //ͼ������
				private Date date;        //����ʱ��
				private String name;  //��ʵ����
				private String address;
				private String phonenumber;
				private double price;//�ܼ۸�
				private String order_state; //����״̬
				private String order_remark;//��ע*/
				// ������
				for (int i = 0; i < littlelist.size(); i++) {
					if (i < littlelist.size()) {
						Order o = littlelist.get(i);
						obj[i][0]= o.getOrder_id();
						obj[i][1] = o.getBook_id();
						obj[i][2] = o.getUsername();
						obj[i][3] = o.getBook_name();
						obj[i][4] = o.getOrder_sum();
						obj[i][5] = o.getDate();
						obj[i][6] = o.getName();
						obj[i][7] = o.getAddress();
						obj[i][8] = o.getPhonenumber();
						obj[i][9] = o.getPrice();
						obj[i][10] = o.getOrder_state();
						obj[i][11] = o.getOrder_remark();
						
					}
				}

				DefaultTableModel dtm = new DefaultTableModel(obj, str);
				// ���ñ�����ʽ
				table.setModel(dtm);

				table.getColumnModel().getColumn(0).setPreferredWidth(50);
				table.getColumnModel().getColumn(1).setPreferredWidth(25);
				table.getColumnModel().getColumn(2).setPreferredWidth(25);
				table.getColumnModel().getColumn(3).setPreferredWidth(25);
				table.getColumnModel().getColumn(4).setPreferredWidth(25);
				table.getColumnModel().getColumn(5).setPreferredWidth(25);
				table.getColumnModel().getColumn(6).setPreferredWidth(25);
				table.getColumnModel().getColumn(7).setPreferredWidth(25);
				table.getColumnModel().getColumn(8).setPreferredWidth(50);
				table.getColumnModel().getColumn(9).setPreferredWidth(25);
				table.getColumnModel().getColumn(10).setPreferredWidth(25);
				table.getColumnModel().getColumn(11).setPreferredWidth(100);
				

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
				table.getTableHeader().getColumnModel().getColumn(6).setCellRenderer(render);
				table.getTableHeader().getColumnModel().getColumn(7).setCellRenderer(render);
				table.getTableHeader().getColumnModel().getColumn(8).setCellRenderer(render);
				table.getTableHeader().getColumnModel().getColumn(9).setCellRenderer(render);
				table.getTableHeader().getColumnModel().getColumn(10).setCellRenderer(render);
				table.getTableHeader().getColumnModel().getColumn(11).setCellRenderer(render);
				
			}
			private void init() {
				
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				OrderDao od = new OrderDaoImpl(conn);
				this.ALLlist = od.domanagerallselect();
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
