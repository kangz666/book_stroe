package cn.kangz.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.kangz.dao.UserDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.UserDaoImpl;
import cn.kangz.pojo.User;

public class MenuShow {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	private static ShowJDialog dialogs ;
	private static ForgetJDialog dialogf;
	private static ManagerLo ml;
	private static Shopping s;
	private static MenuShow ms=null;
	
	//ÿ��ֻ�й��������ע��������оͲ��ٴ������� ֻ����һ���������
	public static synchronized MenuShow getInstance() {
		if(ms==null) {
			ms= new MenuShow();
		}
		return ms;
	}

	/**
	 * Create the application.
	 */
	public MenuShow() {
		initialize();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);//���������ʾ
		frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("��¼����");
		ImageIcon icon = new ImageIcon("book_stroe//pictrue//��¼����.jpg");
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
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 25));
		lblNewLabel.setBounds(132, 30, 72, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(132, 122, 72, 36);
		panel.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(206, 33, 158, 39);
		panel.add(username);
		
		password = new JPasswordField();
		password.setBounds(206, 119, 158, 39);
		panel.add(password);
		
		JButton regis = new JButton("ע��");
		regis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dialogs = ShowJDialog.getInstance();
				dialogs.setVisible(true);//��ʾ����
				dialogs.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//��������˳�
				
			}
		});
		regis.setBounds(105, 204, 86, 36);
		panel.add(regis);
		
		JButton login = new JButton("��¼");
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//��ȡ�ַ���
				String useranemstring = username.getText().trim();
				String passwordstring = password.getText().trim();
				User u = new User(useranemstring,passwordstring);
				//�������ݿ�
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				UserDao ud = new UserDaoImpl(conn);
				boolean login2 = ud.login(u);
				if(login2) {
					JOptionPane.showMessageDialog(null, "��½�ɹ���");
					frame.setVisible(false);
					s = Shopping.getInstance(u);
					
				}else {
					JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ��û����������");
					password.setText("");
				}
				
			}
		});
		login.setBounds(205, 204, 86, 36);
		panel.add(login);
		
		JButton forget = new JButton("��������");
		forget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogf = ForgetJDialog.getInstance();
				dialogf.setVisible(true);//��ʾ����
				dialogf.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//��������˳�
			}
		});
		forget.setBounds(305, 204, 110, 36);
		panel.add(forget);
		
		JButton btnNewButton = new JButton("����Ա");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ml=ManagerLo.getInstance();
			}
		});
		btnNewButton.setBounds(14, 204, 77, 36);
		panel.add(btnNewButton);
		
		frame.setSize(icon.getIconWidth(), icon.getIconHeight());
		
		frame.setBounds(100, 100, 447, 297);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
