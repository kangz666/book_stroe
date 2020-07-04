package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.kangz.dao.UserDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.UserDaoImpl;
import cn.kangz.pojo.User;

public class ShowJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField username;
	private JTextField password;
	private JTextField phonenumber;
	private JTextField name;
	private JTextField address;
	private static ShowJDialog dialog = null;
	
	//每次只有构造是如果注册界面已有就不再创建对象 只会有一个对象存在
		public static synchronized ShowJDialog getInstance() {
			if(dialog==null) {
				dialog= new ShowJDialog();
			}
			return dialog;
		}
	

	/**
	 * Create the dialog.
	 */
	public ShowJDialog() {
		setTitle("注册");
		setBounds(100, 100, 493, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("账号");
			lblNewLabel.setBounds(69, 43, 72, 27);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("密码");
			lblNewLabel_1.setBounds(69, 83, 72, 27);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("手机号码");
			lblNewLabel_2.setBounds(69, 123, 72, 34);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("注册账号");
			lblNewLabel_3.setBounds(177, 13, 72, 27);
			panel.add(lblNewLabel_3);
			
			username = new JTextField();
			username.setBounds(152, 44, 181, 24);
			panel.add(username);
			username.setColumns(10);
			
			password = new JTextField();
			password.setBounds(155, 84, 178, 24);
			panel.add(password);
			password.setColumns(10);
			
			phonenumber = new JTextField();
			phonenumber.setBounds(155, 128, 178, 24);
			panel.add(phonenumber);
			phonenumber.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("姓名");
			lblNewLabel_4.setBounds(69, 170, 72, 34);
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("地址");
			lblNewLabel_5.setBounds(69, 217, 72, 27);
			panel.add(lblNewLabel_5);
			
			name = new JTextField();
			name.setBounds(152, 175, 181, 24);
			panel.add(name);
			name.setColumns(10);
			
			address = new JTextField();
			address.setBounds(152, 218, 181, 24);
			panel.add(address);
			address.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确定");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String usernamestring = username.getText().trim();
						String passwordstring = password.getText().trim();
						String namestring = name.getText().trim();
						String phonenumberstring = phonenumber.getText().trim();
						String addressstring = address.getText().trim();
						//将用户信息添加到用户对象中
						User u = new User(usernamestring,passwordstring,namestring,phonenumberstring,addressstring);
						//连接数据库
						DatabaseConnection dc = new DatabaseConnection();
						Connection conn = dc.getConnection();
						
						UserDao ud=new UserDaoImpl(conn);
						try {
							boolean iscontain = ud.iscontain(u);
							if(!iscontain) {
								
							boolean resgis = ud.resgis(u);
							if(resgis) {
								String  message = "注册成功";
								JOptionPane.showMessageDialog(null, message);
								dialog.dispose();
							}else {
								String  message = "注册失败";
								JOptionPane.showMessageDialog(null, message);
							}
							
							}else {
								String  message = "该用户已存在";
								JOptionPane.showMessageDialog(null, message);
							}
							
							dc.close();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						username.setText("");
						password.setText("");
						name.setText("");
						phonenumber.setText("");
						address.setText("");
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
