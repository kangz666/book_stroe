package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.kangz.dao.ManagerDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.ManagerDaoImpl;
import cn.kangz.pojo.Book_info;
import cn.kangz.pojo.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class RigMaJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField password;
	private JTextField phone;
	private JTextField email;
	private static RigMaJDialog dialog = null;
	//每次只有构造是如果注册界面已有就不再创建对象 只会有一个对象存在
			public static synchronized RigMaJDialog getInstance(Manager m) {
				if(dialog==null) {
					dialog= new RigMaJDialog(m);
				}
				return dialog;
			}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			RigMaJDialog dialog = new RigMaJDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public RigMaJDialog(Manager m) {
		setTitle("\u4FEE\u6539\u4FE1\u606F");
		setBounds(100, 100, 450, 231);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("密码");
				lblNewLabel.setBounds(75, 13, 72, 18);
				panel.add(lblNewLabel);
			}
			{
				password = new JTextField();
				password.setBounds(186, 10, 189, 24);
				panel.add(password);
				password.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel("手机号码");
				lblNewLabel.setBounds(75, 55, 72, 18);
				panel.add(lblNewLabel);
			}
			{
				phone = new JTextField();
				phone.setColumns(10);
				phone.setBounds(186, 52, 189, 24);
				panel.add(phone);
			}
			{
				JLabel lblNewLabel = new JLabel("邮箱");
				lblNewLabel.setBounds(75, 104, 72, 18);
				panel.add(lblNewLabel);
			}
			{
				email = new JTextField();
				email.setColumns(10);
				email.setBounds(186, 101, 189, 24);
				panel.add(email);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确认");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String passwordstring = password.getText().trim();
						String phonestring = phone.getText().trim();
						String emailstring = email.getText().trim();
						Manager newm = new Manager(m.getManager_id(),passwordstring,phonestring,emailstring);
						//连接数据库
						DatabaseConnection dc = new DatabaseConnection();
						Connection conn = dc.getConnection();
						ManagerDao md =new ManagerDaoImpl(conn);
						boolean doupdate = md.doupdate(newm);
						if(doupdate) {
							JOptionPane.showMessageDialog(contentPanel, "修改成功");
						}
						else {
							JOptionPane.showMessageDialog(contentPanel, "修改失败");
						}
						dc.close();
						
						
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
