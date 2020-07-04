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
		setTitle(u.getUsername().trim() + "�Ĺ��ﳵ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setText("�ܹ�" + ALLlist.size() + "��¼");

		init(u);// ��ʼ��

		JButton delete = new JButton("ɾ��");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				Shop_cartDao sd = new Shop_cartDaoImpl(conn);
				boolean dodelete = sd.dodelete(s, u);
				if (dodelete) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					init(u);
					printable(ALLlist);
				} else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
				}

				dbc.close();
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton update = new JButton("�޸�");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �������ݿ�
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				Shop_cartDao sd = new Shop_cartDaoImpl(conn);
				String inputDialog = JOptionPane.showInputDialog(null, "ͼ������" + s.getBook_name() + "  �������޸Ĺ��ﳵ������",
						"2"); // Ĭ��2
				if(inputDialog != null) {
					boolean doupdate = sd.doupdate(s, u, Integer.parseInt(inputDialog.trim()));
				if (doupdate) {
					JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
					init(u);
					printable(ALLlist);
				} else {
					JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
				}
				}
				
				dc.close();
			}
		});
		update.setIcon(new ImageIcon(CartJDialog.class.getResource("/pictrue/filter.png")));
		panel.add(update);
		delete.setIcon(new ImageIcon(CartJDialog.class.getResource("/pictrue/close_filled.png")));
		panel.add(delete);

		JButton buy = new JButton("����");
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				Order o = new Order();
				if (s != null) {

					String string2 = JOptionPane.showInputDialog(null, "��֧��" + s.getBook_price() + "Ԫ",
							s.getBook_price());
					if (string2 != null) {
						String string = JOptionPane.showInputDialog(null, "ȷ����Ϣ���Ƿ�������Ҫ��������", "��������õģ�");
						// ��װ
						/*
						 * private String order_id; //������ private String book_id; private String
						 * manager_id; //������ private String username; //�û��� private String book_name;
						 * //���� private String order_sum; //ͼ������ private Date date; //����ʱ�� private
						 * String name; //��ʵ���� private String address; private String phonenumber;
						 * private double price;//�ܼ۸� private String order_state; //����״̬ private String
						 * order_remark;//��ע
						 */
						o.setOrder_id(String.valueOf(System.currentTimeMillis()));// ��ǰ�ĺ���ֵ��Ϊ������
						o.setBook_id(s.getBook_id());
						o.setManager_id(" ");// �����ֵ
						o.setUsername(u.getUsername());
						o.setBook_name(s.getBook_name());
						o.setOrder_sum(s.getOrder_sum());
						o.setName(u.getName());
						o.setAddress(u.getAddress());
						o.setPhonenumber(u.getIphonenumber());
						o.setPrice(s.getBook_price());
						o.setOrder_state("δ����");

						if (string == null || string.length() < 0) {
							o.setOrder_remark("  ");
						} else {
							o.setOrder_remark(string.trim());
						}

						if (Double.parseDouble(string2.trim()) < s.getBook_price()) {
							JOptionPane.showMessageDialog(null, "֧��ʧ�ܣ�");
						} else {

							OrderDao od = new OrderDaoImpl(conn);
							boolean submit = od.doSubmit(o);
							if (submit) {
								JOptionPane.showMessageDialog(null, "����ɹ��������ҵĶ�����ѯ��");

								Shop_cartDao sd = new Shop_cartDaoImpl(conn);
								boolean dodelete = sd.dodelete(s, u);
							} else {
								JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
							}

						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "��������Ҫ�����ͼ�飡");
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
				// �õ�ѡ�е����е�����ֵ
				int r = table.getSelectedRow();
				int c = table.getSelectedColumn();
				if (r == -1 && c == -1) {
					JOptionPane.showMessageDialog(null, "�����ǰ��Ч");
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
						s.setBook_price((Double.parseDouble(value[i][3].toString())));// �ַ���תΪdouble
					}
					// System.out.println(s);
				}
			}
		});

		printable(ALLlist);
		JScrollPane scrollPane = new JScrollPane(table);
		// ���ù�������λ�� ��ֱ����ʾ��ˮƽ��ȡ��
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
		lblNewLabel.setText("�ܹ�" + ALLlist.size() + "��¼");
		// System.out.println(ALLlist);
		dbc.close();
	}

	public static void printable(ArrayList<Shop_cart> littlelist) {

		((DefaultTableModel) table.getModel()).getDataVector().clear(); // ����������
		((DefaultTableModel) table.getModel()).fireTableDataChanged();// ֪ͨģ�͸���
		table.updateUI();// ˢ�±��

		String[] str = new String[] { "���", "����", "����", "�ܼ۸�" };
		Object[][] obj = new Object[littlelist.size()][4];

		/*
		 * private String book_id; private String book_name; private String order_sum;
		 * private double book_price;
		 */
		// ������
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
		// ���ñ�����ʽ
		table.setModel(dtm);

		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);

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

	}

}
