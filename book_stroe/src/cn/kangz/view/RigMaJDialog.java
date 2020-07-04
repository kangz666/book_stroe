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
	//ÿ��ֻ�й��������ע��������оͲ��ٴ������� ֻ����һ���������
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
				JLabel lblNewLabel = new JLabel("����");
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
				JLabel lblNewLabel = new JLabel("�ֻ�����");
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
				JLabel lblNewLabel = new JLabel("����");
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
				JButton okButton = new JButton("ȷ��");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String passwordstring = password.getText().trim();
						String phonestring = phone.getText().trim();
						String emailstring = email.getText().trim();
						Manager newm = new Manager(m.getManager_id(),passwordstring,phonestring,emailstring);
						//�������ݿ�
						DatabaseConnection dc = new DatabaseConnection();
						Connection conn = dc.getConnection();
						ManagerDao md =new ManagerDaoImpl(conn);
						boolean doupdate = md.doupdate(newm);
						if(doupdate) {
							JOptionPane.showMessageDialog(contentPanel, "�޸ĳɹ�");
						}
						else {
							JOptionPane.showMessageDialog(contentPanel, "�޸�ʧ��");
						}
						dc.close();
						
						
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
