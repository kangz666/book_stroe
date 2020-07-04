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
	
	//每次只有构造是如果注册界面已有就不再创建对象 只会有一个对象存在
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
		frame.setLocationRelativeTo(null);//窗体居中显示
		frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("登录窗口");
		ImageIcon icon = new ImageIcon("book_stroe//pictrue//登录界面.jpg");
		// Image im=new Image(icon);
		// 将图片放入label中
		JLabel label = new JLabel(icon);

		// 设置label的大小
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

		// 获取窗口的第二层，将label放入
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel panel = new JPanel();
		// 获取frame的顶层容器,并设置为透明
		JPanel j = (JPanel) frame.getContentPane();
		j.setOpaque(false);
		// 必须设置为透明的。否则看不到图片
		panel.setOpaque(false);

		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账号");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel.setBounds(132, 30, 72, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(132, 122, 72, 36);
		panel.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(206, 33, 158, 39);
		panel.add(username);
		
		password = new JPasswordField();
		password.setBounds(206, 119, 158, 39);
		panel.add(password);
		
		JButton regis = new JButton("注册");
		regis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dialogs = ShowJDialog.getInstance();
				dialogs.setVisible(true);//显示窗口
				dialogs.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//点击可以退出
				
			}
		});
		regis.setBounds(105, 204, 86, 36);
		panel.add(regis);
		
		JButton login = new JButton("登录");
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//获取字符串
				String useranemstring = username.getText().trim();
				String passwordstring = password.getText().trim();
				User u = new User(useranemstring,passwordstring);
				//连接数据库
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				UserDao ud = new UserDaoImpl(conn);
				boolean login2 = ud.login(u);
				if(login2) {
					JOptionPane.showMessageDialog(null, "登陆成功！");
					frame.setVisible(false);
					s = Shopping.getInstance(u);
					
				}else {
					JOptionPane.showMessageDialog(null, "登录失败！用户名密码错误");
					password.setText("");
				}
				
			}
		});
		login.setBounds(205, 204, 86, 36);
		panel.add(login);
		
		JButton forget = new JButton("忘记密码");
		forget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogf = ForgetJDialog.getInstance();
				dialogf.setVisible(true);//显示窗口
				dialogf.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//点击可以退出
			}
		});
		forget.setBounds(305, 204, 110, 36);
		panel.add(forget);
		
		JButton btnNewButton = new JButton("管理员");
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
