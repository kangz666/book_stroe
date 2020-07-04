package cn.kangz.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.kangz.dao.ManagerDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.ManagerDaoImpl;
import cn.kangz.pojo.Manager;

public class ManagerLo {

	private JFrame frame;
	private JTextField ID;
	private JPasswordField password;
	private static ManagerMenu mm ;
	private static ManagerLo ml=null;
	public static synchronized ManagerLo getInstance() {
		if(ml==null) {
			ml=new ManagerLo();
		}
		return ml;
	}
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManagerLo window = new ManagerLo();
//					window.frame.setVisible(true);
//					window.frame.setResizable(false);
//					window.frame.setLocationRelativeTo(null);//���������ʾ
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ManagerLo() {
		initialize();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);//���������ʾ
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImageIcon icon = new ImageIcon("book_stroe//pictrue//bookworld.jpg");
		// Image im=new Image(icon);
		// ��ͼƬ����label��
		JLabel label = new JLabel(icon);

		// ����label�Ĵ�С
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

		// ��ȡ���ڵĵڶ��㣬��label����
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel panel = new JPanel();
		// ��ȡframe�Ķ�������,������Ϊ͸��
		JPanel j = (JPanel) frame.getContentPane();
		j.setOpaque(false);
		// ��������Ϊ͸���ġ����򿴲���ͼƬ
		panel.setOpaque(false);

		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�˺�");
		lblNewLabel.setBounds(141, 101, 72, 18);
		panel.add(lblNewLabel);
		
		ID = new JTextField();
		ID.setBounds(242, 100, 187, 24);
		panel.add(ID);
		ID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setBounds(141, 171, 72, 18);
		panel.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(242, 171, 187, 24);
		panel.add(password);
		
		JButton L = new JButton("��¼");
		L.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//frame.setVisible(true);
				String idstring = ID.getText().trim();
				String passwordstring = password.getText().trim();
				Manager m = new Manager(idstring,passwordstring);
				//�������ݿ�
				DatabaseConnection dc = new DatabaseConnection();
				Connection conn = dc.getConnection();
				
				ManagerDao md = new ManagerDaoImpl(conn);
				boolean dologin = md.dologin(m);
				if(dologin) {
					mm = ManagerMenu.getInstance(m);
					frame.setVisible(false);
				}else {
					String message = "��������ȷ���û��������룡";
					JOptionPane.showMessageDialog(panel, message);
				}
			}
		});
		L.setBounds(92, 264, 113, 27);
		panel.add(L);
		
		JButton C = new JButton("ȡ��");
		C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				
			}
		});
		C.setBounds(357, 264, 113, 27);
		panel.add(C);
		
		frame.setSize(icon.getIconWidth(), icon.getIconHeight());
		
		frame.setBounds(100, 100, 590, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
