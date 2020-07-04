package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UntreatedOrder extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JLabel blNewLabel;
	static ArrayList<Order> ALLlist = new ArrayList<Order>();
	static Order o = new Order();
//	Manager m = new Manager("abc123","8888");
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UntreatedOrder frame = new UntreatedOrder();
//					//frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UntreatedOrder(Manager m) {
		
		setTitle("δ������");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// �õ�ѡ�е����е�����ֵ
				int r = table.getSelectedRow();
				int c = table.getSelectedColumn();
				if (r == -1 && c == -1) {
					JOptionPane.showMessageDialog(null, "�����ǰ��Ч");
				} else {
					Object[][] value = new Object[r + 1][12];
					for (int i = r; i < r + 1; i++) {
						for (int j = 0; j < 12; j++) {
							value[i][j] = table.getValueAt(i, j);
						}
					}
					for (int i = r; i < r + 1; i++) {
						o.setOrder_id(((value[i][0].toString())));
						o.setBook_id((value[i][1].toString()));	
						o.setPrice(Double.parseDouble(value[i][9].toString()));
						
					}
					 //System.out.println(o);
				}
			}
		});
		table.setRowHeight(30); 
		
		table.getTableHeader().setReorderingAllowed(false);//�����û��������������еĿ��
		table.getTableHeader().setResizingAllowed(false);//�������û������϶��еĿ��
		init();
		printable(ALLlist);
		JScrollPane scrollPane = new JScrollPane(table);
		//���ù�������λ�� ��ֱ����ʾ��ˮƽ��ʾ
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("�ѷ���");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �������ݿ�
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				OrderDao od = new OrderDaoImpl(conn);
				String string = JOptionPane.showInputDialog(null,"ȷ��������","ȷ��");
				if(string != null) {
					if((string.trim().equals("ȷ��"))) {
					boolean doUpdateorder = od.doUpdateorder(o, m, "�ѷ���");
					if (doUpdateorder) {
						JOptionPane.showMessageDialog(null, "�ѷ�����");
						init();
						printable(ALLlist);
						//��¼
						RecordDao rd =new RecordDaoImpl();
						Date date = new Date(System.currentTimeMillis());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String stringdate = sdf.format(date);
						rd.inputrecord(m, new Record(m.getManager_id(),o.getOrder_id(),"�ѷ���",stringdate,String.valueOf(o.getPrice())));
						} else {
							JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
						}
				}
			}
				dc.close();
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�Ѷϻ�");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �������ݿ�
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				OrderDao od = new OrderDaoImpl(conn);
				String string = JOptionPane.showInputDialog(null,"ȷ���ϻ���","ȷ��");
				if(string != null) {
					if((string.trim().equals("ȷ��"))) {
					boolean doUpdateorder = od.doUpdateorder(o, m, "�Ѷϻ�");
					if (doUpdateorder) {
						JOptionPane.showMessageDialog(null, "�Ѷϻ���");
						init();
						printable(ALLlist);
						//��¼
						RecordDao rd =new RecordDaoImpl();
						Date date = new Date(System.currentTimeMillis());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String stringdate = sdf.format(date);
						rd.inputrecord(m, new Record(m.getManager_id(),o.getOrder_id(),"�Ѷϻ�",stringdate,String.valueOf(o.getPrice())));
						} else {
							JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
						}
				}
			}
				dc.close();
			}
		});
		panel_1.add(btnNewButton_1);
		
		 blNewLabel = new JLabel("");
		 panel_1.add(blNewLabel);
		 blNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		 blNewLabel.setText("�ܹ�" + ALLlist.size() + "��¼");
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		this.ALLlist = od.domanagerfalseselect();
		// System.out.println(ALLlist);
		dbc.close();
		
	}

}
