package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;

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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cn.kangz.dao.OrderDao;
import cn.kangz.dao.Shop_cartDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.OrderDaoImpl;
import cn.kangz.impl.Shop_cartDaoImpl;
import cn.kangz.pojo.Order;
import cn.kangz.pojo.Shop_cart;
import cn.kangz.pojo.User;

public class CartJDialog extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static JLabel lblNewLabel;
	static ArrayList<Shop_cart> ALLlist = new ArrayList<Shop_cart>();
	static Shop_cart s = new Shop_cart();

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CartJDialog frame = new CartJDialog();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CartJDialog(User u) {
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
		setTitle(u.getUsername().trim() + "的购物车");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 18));
		lblNewLabel.setText("总共" + ALLlist.size() + "记录");

		init(u);// 初始化

		JButton delete = new JButton("删除");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				Shop_cartDao sd = new Shop_cartDaoImpl(conn);
				boolean dodelete = sd.dodelete(s, u);
				if (dodelete) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					init(u);
					printable(ALLlist);
				} else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}

				dbc.close();
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton update = new JButton("修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 连接数据库
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				Shop_cartDao sd = new Shop_cartDaoImpl(conn);
				String inputDialog = JOptionPane.showInputDialog(null, "图书名：" + s.getBook_name() + "  请输入修改购物车的数量",
						"2"); // 默认2
				if(inputDialog != null) {
					boolean doupdate = sd.doupdate(s, u, Integer.parseInt(inputDialog.trim()));
				if (doupdate) {
					JOptionPane.showMessageDialog(null, "修改成功！");
					init(u);
					printable(ALLlist);
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！");
				}
				}
				
				dc.close();
			}
		});
		update.setIcon(new ImageIcon(CartJDialog.class.getResource("/pictrue/filter.png")));
		panel.add(update);
		delete.setIcon(new ImageIcon(CartJDialog.class.getResource("/pictrue/close_filled.png")));
		panel.add(delete);

		JButton buy = new JButton("购买");
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				Order o = new Order();
				if (s != null) {

					String string2 = JOptionPane.showInputDialog(null, "请支付" + s.getBook_price() + "元",
							s.getBook_price());
					if (string2 != null) {
						String string = JOptionPane.showInputDialog(null, "确认信息，是否有特殊要求，请输入", "卖家是最好的！");
						// 封装
						/*
						 * private String order_id; //订单号 private String book_id; private String
						 * manager_id; //处理人 private String username; //用户名 private String book_name;
						 * //书名 private String order_sum; //图书数量 private Date date; //订单时间 private
						 * String name; //真实姓名 private String address; private String phonenumber;
						 * private double price;//总价格 private String order_state; //订单状态 private String
						 * order_remark;//备注
						 */
						o.setOrder_id(String.valueOf(System.currentTimeMillis()));// 当前的毫秒值作为订单号
						o.setBook_id(s.getBook_id());
						o.setManager_id(" ");// 输入空值
						o.setUsername(u.getUsername());
						o.setBook_name(s.getBook_name());
						o.setOrder_sum(s.getOrder_sum());
						o.setName(u.getName());
						o.setAddress(u.getAddress());
						o.setPhonenumber(u.getIphonenumber());
						o.setPrice(s.getBook_price());
						o.setOrder_state("未处理");

						if (string == null || string.length() < 0) {
							o.setOrder_remark("  ");
						} else {
							o.setOrder_remark(string.trim());
						}

						if (Double.parseDouble(string2.trim()) < s.getBook_price()) {
							JOptionPane.showMessageDialog(null, "支付失败！");
						} else {

							OrderDao od = new OrderDaoImpl(conn);
							boolean submit = od.doSubmit(o);
							if (submit) {
								JOptionPane.showMessageDialog(null, "购买成功！可在我的订单查询。");

								Shop_cartDao sd = new Shop_cartDaoImpl(conn);
								boolean dodelete = sd.dodelete(s, u);
							} else {
								JOptionPane.showMessageDialog(null, "购买失败！");
							}

						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "请点击您需要购买的图书！");
				}

				dbc.close();

			}
		});
		buy.setIcon(new ImageIcon(CartJDialog.class.getResource("/pictrue/\u6210\u529F.png")));
		panel.add(buy);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		table.setRowHeight(30);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 得到选中的行列的索引值
				int r = table.getSelectedRow();
				int c = table.getSelectedColumn();
				if (r == -1 && c == -1) {
					JOptionPane.showMessageDialog(null, "点击当前无效");
				} else {
					Object[][] value = new Object[r + 1][6];
					for (int i = r; i < r + 1; i++) {
						for (int j = 0; j < 4; j++) {
							value[i][j] = table.getValueAt(i, j);
						}
					}
					for (int i = r; i < r + 1; i++) {
						s.setShop_id(u.getUsername());
						s.setBook_id((value[i][0].toString()));
						s.setBook_name((value[i][1].toString()));
						s.setOrder_sum((value[i][2].toString()));
						s.setBook_price((Double.parseDouble(value[i][3].toString())));// 字符串转为double
					}
					// System.out.println(s);
				}
			}
		});

		printable(ALLlist);
		JScrollPane scrollPane = new JScrollPane(table);
		// 设置滚动条的位置 垂直的显示，水平的取消
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane);

		panel.add(lblNewLabel);

	}

	public static void init(User u) {
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		Shop_cartDao sd = new Shop_cartDaoImpl(conn);
		ALLlist = sd.doselectall(u);
		lblNewLabel.setText("总共" + ALLlist.size() + "记录");
		// System.out.println(ALLlist);
		dbc.close();
	}

	public static void printable(ArrayList<Shop_cart> littlelist) {

		((DefaultTableModel) table.getModel()).getDataVector().clear(); // 清除表格数据
		((DefaultTableModel) table.getModel()).fireTableDataChanged();// 通知模型更新
		table.updateUI();// 刷新表格

		String[] str = new String[] { "编号", "书名", "数量", "总价格" };
		Object[][] obj = new Object[littlelist.size()][4];

		/*
		 * private String book_id; private String book_name; private String order_sum;
		 * private double book_price;
		 */
		// 加入表格
		for (int i = 0; i < littlelist.size(); i++) {
			if (i < littlelist.size()) {
				Shop_cart s = littlelist.get(i);
				obj[i][0] = s.getBook_id();
				obj[i][1] = s.getBook_name();
				obj[i][2] = s.getOrder_sum();
				obj[i][3] = s.getBook_price();
			}
		}

		DefaultTableModel dtm = new DefaultTableModel(obj, str);
		// 设置表格的样式
		table.setModel(dtm);

		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);

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

	}

}
