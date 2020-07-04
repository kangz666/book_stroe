package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.kangz.dao.UserDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.UserDaoImpl;
import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class Userupdate extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField username;
	private JTextField password;
	private JTextField name;
	private JTextField phonenumber;
	private JTextField address;
	private static Userupdate dialog = null;
	//每次只有构造是如果注册界面已有就不再创建对象 只会有一个对象存在
	public static synchronized Userupdate getInstance(User u) {
		if(dialog==null) {
			dialog= new Userupdate(u);
			}
			return dialog;
		}
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			Userupdate dialog = new Userupdate();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Userupdate(User u) {
		setTitle("修改");
		setBounds(100, 100, 450, 333);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("用户名");
				lblNewLabel.setBounds(66, 43, 72, 18);
				panel.add(lblNewLabel);
			}
			{
				username = new JTextField();
				username.setText(u.getUsername());
				username.setEnabled(false);
				username.setBounds(182, 40, 168, 24);
				panel.add(username);
				username.setColumns(10);
			}
			
			JLabel lblNewLabel_1 = new JLabel("修改信息");
			lblNewLabel_1.setBounds(173, 13, 72, 18);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel = new JLabel("密码");
			lblNewLabel.setBounds(66, 91, 72, 18);
			panel.add(lblNewLabel);
			
			password = new JTextField();
			password.setText(u.getPassword());
			password.setColumns(10);
			password.setBounds(182, 88, 168, 24);
			panel.add(password);
			
			JLabel lblNewLabel_2 = new JLabel("姓名");
			lblNewLabel_2.setBounds(66, 134, 72, 18);
			panel.add(lblNewLabel_2);
			
			name = new JTextField();
			name.setText(u.getName());
			name.setColumns(10);
			name.setBounds(182, 131, 168, 24);
			panel.add(name);
			
			JLabel lblNewLabel_3 = new JLabel("手机号码");
			lblNewLabel_3.setBounds(66, 172, 72, 18);
			panel.add(lblNewLabel_3);
			
			phonenumber = new JTextField();
			phonenumber.setText(u.getIphonenumber());
			phonenumber.setColumns(10);
			phonenumber.setBounds(182, 169, 168, 24);
			panel.add(phonenumber);
			
			JLabel lblNewLabel_4 = new JLabel("地址");
			lblNewLabel_4.setBounds(66, 205, 72, 18);
			panel.add(lblNewLabel_4);
			
			address = new JTextField();
			address.setText(u.getAddress());
			address.setColumns(10);
			address.setBounds(182, 202, 168, 24);
			panel.add(address);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确认修改");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//获取字符串
						String string1 = username.getText().trim();
						String string2 = password.getText().trim();
						String string3 = name.getText().trim();
						String string4 = phonenumber.getText().trim();
						String string5 = address.getText().trim();
						//建立新对象
						User newu = new User(string1,string2,string3,string4,string5);
						
						//连接数据库
						DatabaseConnection dbc = new DatabaseConnection();
						Connection conn = dbc.getConnection();
						UserDao ud= new UserDaoImpl(conn);
						boolean update = ud.update(newu);
						if(update) {
							JOptionPane.showMessageDialog(null, "修改成功！");
						}else {
							JOptionPane.showMessageDialog(null, "修改失败！");
						}
						dbc.close();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dialog.dispose();
						
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
