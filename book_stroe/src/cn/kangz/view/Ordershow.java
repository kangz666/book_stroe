package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cn.kangz.dao.OrderDao;
import cn.kangz.dao.Shop_cartDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.OrderDaoImpl;
import cn.kangz.impl.Shop_cartDaoImpl;
import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Order;
import cn.kangz.pojo.Shop_cart;
import cn.kangz.pojo.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ordershow extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static JLabel lblNewLabel;
	static ArrayList<Order> ALLlist = new ArrayList<Order>();
	//static User u = new User("111","444");
	static Order o = new Order();
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JButton button;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ordershow frame = new Ordershow(u);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Ordershow(User u) {
		setTitle(u.getUsername()+"的订单");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1148, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);//居中
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 18));
		lblNewLabel.setText("总共" + ALLlist.size() + "记录");
		
		init(u);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 得到选中的行列的索引值
				int r = table.getSelectedRow();
				int c = table.getSelectedColumn();
				if (r == -1 && c == -1) {
					JOptionPane.showMessageDialog(null, "点击当前无效");
				} else {
					Object[][] value = new Object[r + 1][8];
					for (int i = r; i < r + 1; i++) {
						for (int j = 0; j < 8; j++) {
							value[i][j] = table.getValueAt(i, j);
						}
					}
					for (int i = r; i < r + 1; i++) {
//						s.setShop_id(u.getUsername());
//						s.setBook_id((value[i][0].toString()));
//						s.setBook_name((value[i][1].toString()));
//						s.setOrder_sum((value[i][2].toString()));
//						s.setBook_price((Double.parseDouble(value[i][3].toString())));// 字符串转为double
						//String[] str = new String[] { "订单号", "图书编号", "图书名称", "图书数量","订单时间","金额","订单状态","备注"};
						o.setOrder_id((value[i][0].toString()));
						o.setBook_id((value[i][1].toString()));
						o.setBook_name((value[i][2].toString()));
						o.setOrder_sum(value[i][3].toString());
						
						o.setPrice((Double.parseDouble(value[i][5].toString())));
						o.setOrder_state((value[i][6].toString()));
						o.setOrder_remark((value[i][7].toString()));
					}
					// System.out.println(o);
				}
			}
		});
		table.setRowHeight(30);
		
		printable(ALLlist);
		JScrollPane scrollPane = new JScrollPane(table);
		// 设置滚动条的位置 垂直的显示，水平的取消
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		
		panel_1.add(lblNewLabel);
		
		button = new JButton("取消订单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 连接数据库
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				OrderDao od = new OrderDaoImpl(conn);
				String inputDialog = JOptionPane.showInputDialog(null, "订单图书：" + o.getBook_name() + "  请输入取消原因",
						"不喜欢了，我就是三分钟热度"); // 默认不喜欢了，我就是三分钟热度
				if(inputDialog != null) {
					Order newo = new Order();
					newo.setOrder_id(o.getOrder_id());
					newo.setOrder_state("退款");
					newo.setOrder_remark(inputDialog.trim());
					boolean doUpdate = od.doUpdate(newo, "  ");
				if (doUpdate) {
					JOptionPane.showMessageDialog(null, "成功取消订单！");
					init(u);
					printable(ALLlist);
				} else {
					JOptionPane.showMessageDialog(null, "取消失败！");
				}
				}else {
					JOptionPane.showMessageDialog(null, "请输入原因！本次取消失败。");
				}
				
				dbc.close();
			}
			
		});
		panel_1.add(button);
		
		
		btnNewButton_2 = new JButton("价格降序");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 连接数据库
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				OrderDao od = new OrderDaoImpl(conn);
				
				ArrayList<Order> doselectsort = od.doselectsort(u);
				printable(doselectsort);
				
				dbc.close();
				
			}
		});
		panel_1.add(btnNewButton_2);
		
	setVisible(true);
	
		
	}
	public static void init(User u) {
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		OrderDao od = new OrderDaoImpl(conn);
		ALLlist = od.douserselect(u);
		lblNewLabel.setText("总共" + ALLlist.size() + "记录");
		// System.out.println(ALLlist);
		dbc.close();
	}

	public static void printable(ArrayList<Order> littlelist){

		((DefaultTableModel) table.getModel()).getDataVector().clear(); // 清除表格数据
		((DefaultTableModel) table.getModel()).fireTableDataChanged();// 通知模型更新
		table.updateUI();// 刷新表格

		String[] str = new String[] { "订单号", "图书编号", "图书名称", "图书数量","订单时间","金额","订单状态","备注"};
		Object[][] obj = new Object[littlelist.size()][8];

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
				obj[i][2] = o.getBook_name();
				obj[i][3] = o.getOrder_sum();
				obj[i][4] = o.getDate();
				obj[i][5] = o.getPrice();
				obj[i][6] = o.getOrder_state();
				obj[i][7] = o.getOrder_remark();
				
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
		table.getColumnModel().getColumn(7).setPreferredWidth(100);

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
		
	}

}

