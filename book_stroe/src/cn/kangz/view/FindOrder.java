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
	private static int curentPageIndex = 1; // 当前页码
	private int countPerpage = 20; // 每页显示条数
	private int pageCount; // 总页数
	private int recordCount; // 总记录条数
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

	// 初始化块，调用类的时候首先自动加载
			{
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				OrderDao od = new OrderDaoImpl(conn);
				this.ALLlist = od.domanagerallselect();
				// System.out.println(ALLlist);
				dbc.close();
				// 计算总页数
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
		// 随系统风格
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
		frame.setTitle("订单");
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
			public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
			
                //得到选中的行列的索引值
               int r= table.getSelectedRow();
               int c= table.getSelectedColumn();
               if(r==-1&&c==-1) {
            	   JOptionPane.showMessageDialog(null,"点击当前无效");
               }else {
            	   Object[][] value = new Object[r+1][11];
               for(int i =r;i<r+1;i++) {
            	   for(int j=0;j<11;j++) {
            		    value[i][j]= table.getValueAt(i, j);
            	   }
               }
               /*private String order_id;  //订单号
   			private String book_id;
   			private String manager_id; //处理人
   			private String username;  //用户名
   			private String book_name;  //书名
   			private String order_sum;  //图书数量
   			private Date date;        //订单时间
   			private String name;  //真实姓名
   			private String address;
   			private String phonenumber;
   			private double price;//总价格
   			private String order_state; //订单状态
   			private String order_remark;//备注*/
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
		
		table.getTableHeader().setReorderingAllowed(false);//运行用户不允许拉动单列的宽度
		table.getTableHeader().setResizingAllowed(false);//不允许用户自行拖动列的宽度

		if(curentPageIndex==1) {
			ArrayList<Order> select = select();
			printable(select);
		}
		JScrollPane scrollPane = new JScrollPane(table);
		//设置滚动条的位置 垂直的显示，水平显示
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		JLabel data = new JLabel();
		data.setText("总共"+ALLlist.size()+"记录|当前第"+curentPageIndex+"页|共"+pageCount+"页");
		panel_1.add(data);
		
		//上一页
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ArrayList<Order> previousPage =previousPage();
					printable(previousPage);
			}
		});
		back.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/page_turning_left.png")));
		panel_1.add(back);
		//刷新
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
		//下一页
		JButton next = new JButton("");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						ArrayList<Order> nextPage = nextPage();
				       printable(nextPage);
	 
			}
		});
		next.setIcon(new ImageIcon(ManagerMenu.class.getResource("/pictrue/page_turning_right.png")));
		panel_1.add(next);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dialog = JOptionPane.showInputDialog(null,"请输入查询的用户名。","用户名");
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
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//连接数据库
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				OrderDao od = new OrderDaoImpl(conn);
				if(big.getOrder_id() != null) {
					boolean dodelect = od.dodelect(m, big);
					if(dodelect) {
						JOptionPane.showMessageDialog(null, "删除成功");
						init();
						printable(select());
					}else {
						JOptionPane.showMessageDialog(null, "删除失败");
					}
				}
				//记录
				RecordDao rd =new RecordDaoImpl();
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String stringdate = sdf.format(date);
				rd.inputrecord(m, new Record(m.getManager_id(),big.getOrder_id(),"删除订单",stringdate,String.valueOf(big.getPrice())));
			}
		});
		panel_1.add(btnNewButton_1);
	}
	// 下一页
			public ArrayList<Order> nextPage() {

				if (curentPageIndex < pageCount) {
					curentPageIndex++;
					// System.out.println("当前页:"+curentPageIndex);
				} else {
					String message = "当前已经是最后一页！";
					JOptionPane.showMessageDialog(null, message);
				}

				return select();
			}

			// 上一页
			public ArrayList<Order> previousPage() {
				if (curentPageIndex > 1) {
					curentPageIndex--;
					// System.out.println("当前页:"+curentPageIndex);
				} else {
					String message = "当前是第一页！";
					JOptionPane.showMessageDialog(null, message);
				}

				return select();
			}

			/**
			 * 这是一个将大集合按照每个页码的条数划分到小集合里
			 * 
			 * @return 页码集合
			 */
			public ArrayList<Order> select() {
				ArrayList<Order> littlelist = new ArrayList<Order>();
				// 获得总集合的大小
				recordCount = ALLlist.size();
				// 初始的值是 （当前的页码-1）*每页的条数；条件就是i小于大集合的大小并且小于当前页码数*每一页的条数
				for (int i = (curentPageIndex - 1) * countPerpage; i < curentPageIndex * countPerpage && i < recordCount; i++) {
					// 添加到每一页的小集合里面
					littlelist.add(ALLlist.get(i));
				}

				return littlelist;
			}

			/**
			 * 这个是打印表格的方法
			 * 
			 * @param littlelist 页码集合
			 */
			public void printable(ArrayList<Order> littlelist) {
				((DefaultTableModel) table.getModel()).getDataVector().clear(); // 清除表格数据
				((DefaultTableModel) table.getModel()).fireTableDataChanged();// 通知模型更新
				table.updateUI();// 刷新表格
				

				String[] str = new String[] { "订单号", "图书编号","用户名", "图书名称","图书数量","订单时间","真实姓名","地址","电话号码","金额","订单状态","备注"};
				Object[][] obj = new Object[littlelist.size()][12];

				/*private String order_id;  //订单号
				private String book_id;
				private String manager_id; //处理人
				private String username;  //用户名
				private String book_name;  //书名
				private String order_sum;  //图书数量
				private Date date;        //订单时间
				private String name;  //真实姓名
				private String address;
				private String phonenumber;
				private double price;//总价格
				private String order_state; //订单状态
				private String order_remark;//备注*/
				// 加入表格
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
				// 设置表格的样式
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
				

				// 设置表头内容居中
				((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

				// 设置单元格内容居中
				DefaultTableCellRenderer render = new DefaultTableCellRenderer();
				render.setHorizontalAlignment(SwingConstants.CENTER);
				// 设置居中
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
				// 计算总页数
				if (ALLlist.size() % countPerpage == 0) {
					this.pageCount = ALLlist.size() / countPerpage;
				} else {
					this.pageCount = (ALLlist.size() / countPerpage) + 1;
				}
			}
}
