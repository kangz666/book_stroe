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
import cn.kangz.pojo.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class ForgetJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField username;
	private JTextField phonenumber;
	private static ForgetJDialog dialog = null;
	
	//ÿ��ֻ�й��������ע��������оͲ��ٴ������� ֻ����һ���������
		public static synchronized ForgetJDialog getInstance() {
			if(dialog==null) {
				dialog= new ForgetJDialog();
			}
			return dialog;
		}

	/**
	 * Create the dialog.
	 */
	public ForgetJDialog() {
		setTitle("�һ�����");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("����������˺�");
				lblNewLabel.setBounds(14, 31, 121, 36);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("����������ֻ�����");
				lblNewLabel_1.setBounds(14, 85, 142, 30);
				panel.add(lblNewLabel_1);
			}
			{
				username = new JTextField();
				username.setBounds(171, 37, 203, 24);
				panel.add(username);
				username.setColumns(10);
			}
			{
				phonenumber = new JTextField();
				phonenumber.setBounds(169, 88, 205, 24);
				panel.add(phonenumber);
				phonenumber.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("��ѯ");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String usernamestring = username.getText().trim();
						String phonenumberstring = phonenumber.getText().trim();
						//�������ݿ�
						DatabaseConnection dc = new DatabaseConnection();
						Connection conn = dc.getConnection();
						UserDao ud=new UserDaoImpl(conn);
						
						User forget = ud.forget(usernamestring, phonenumberstring);
							//��Ϣ��ʾ����ʾ�û���Ϣ
							JOptionPane.showMessageDialog(null, forget.toString());
							dc.close();
							username.setText("");
							phonenumber.setText("");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("ȡ��");
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
