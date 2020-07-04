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
	
	//ÿ��ֻ�й��������ע��������оͲ��ٴ������� ֻ����һ���������
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
		setTitle("ע��");
		setBounds(100, 100, 493, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("�˺�");
			lblNewLabel.setBounds(69, 43, 72, 27);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("����");
			lblNewLabel_1.setBounds(69, 83, 72, 27);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("�ֻ�����");
			lblNewLabel_2.setBounds(69, 123, 72, 34);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("ע���˺�");
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
			
			JLabel lblNewLabel_4 = new JLabel("����");
			lblNewLabel_4.setBounds(69, 170, 72, 34);
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("��ַ");
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
				JButton okButton = new JButton("ȷ��");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String usernamestring = username.getText().trim();
						String passwordstring = password.getText().trim();
						String namestring = name.getText().trim();
						String phonenumberstring = phonenumber.getText().trim();
						String addressstring = address.getText().trim();
						//���û���Ϣ��ӵ��û�������
						User u = new User(usernamestring,passwordstring,namestring,phonenumberstring,addressstring);
						//�������ݿ�
						DatabaseConnection dc = new DatabaseConnection();
						Connection conn = dc.getConnection();
						
						UserDao ud=new UserDaoImpl(conn);
						try {
							boolean iscontain = ud.iscontain(u);
							if(!iscontain) {
								
							boolean resgis = ud.resgis(u);
							if(resgis) {
								String  message = "ע��ɹ�";
								JOptionPane.showMessageDialog(null, message);
								dialog.dispose();
							}else {
								String  message = "ע��ʧ��";
								JOptionPane.showMessageDialog(null, message);
							}
							
							}else {
								String  message = "���û��Ѵ���";
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
