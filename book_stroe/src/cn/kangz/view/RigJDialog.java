package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.kangz.dao.Book_infoDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.Book_infoDaoImpl;
import cn.kangz.pojo.Book_info;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class RigJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField ID;
	private JTextField name;
	private JTextField auther;
	private JTextField price;
	private JTextField type;
	private JTextField introduction;
	private static RigJDialog dialog = null;
	//ÿ��ֻ�й��������ע��������оͲ��ٴ������� ֻ����һ���������
			public static synchronized RigJDialog getInstance(Book_info b) {
				if(dialog==null) {
					dialog= new RigJDialog(b);
				}
				return dialog;
			}
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			RigJDialog dialog = new RigJDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public RigJDialog(Book_info b) {
		setTitle("�޸�ͼ��");
		setBounds(100, 100, 450, 414);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("ͼ����");
				lblNewLabel.setBounds(75, 13, 72, 18);
				panel.add(lblNewLabel);
			}
			{
				ID = new JTextField();
				ID.setText(b.getBook_id());
				//ID.setEditable(false);//ID���ɱ༭
				ID.setBounds(183, 10, 153, 24);
				panel.add(ID);
				ID.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel("����");
				lblNewLabel.setBounds(75, 62, 72, 18);
				panel.add(lblNewLabel);
			}
			{
				name = new JTextField();
				name.setText(b.getBook_name());
				name.setColumns(10);
				name.setBounds(183, 59, 153, 24);
				panel.add(name);
			}
			{
				JLabel lblNewLabel = new JLabel("����");
				lblNewLabel.setBounds(75, 117, 72, 18);
				panel.add(lblNewLabel);
			}
			{
				auther = new JTextField();
				auther.setText(b.getBook_auther());
				auther.setColumns(10);
				auther.setBounds(183, 114, 153, 24);
				panel.add(auther);
			}
			{
				JLabel lblNewLabel = new JLabel("�۸�");
				lblNewLabel.setBounds(75, 171, 72, 18);
				panel.add(lblNewLabel);
			}
			{
				price = new JTextField();
				price.setText(String.valueOf(b.getBook_price()));
				price.setColumns(10);
				price.setBounds(183, 168, 153, 24);
				panel.add(price);
			}
			{
				JLabel lblNewLabel = new JLabel("����");
				lblNewLabel.setBounds(75, 220, 72, 18);
				panel.add(lblNewLabel);
			}
			{
				type = new JTextField();
				type.setText(b.getBook_type());
				type.setColumns(10);
				type.setBounds(183, 217, 153, 24);
				panel.add(type);
			}
			{
				JLabel lblNewLabel = new JLabel("���");
				lblNewLabel.setBounds(75, 274, 72, 18);
				panel.add(lblNewLabel);
			}
			{
				introduction = new JTextField();
				introduction.setText(b.getBook_introdution());
				introduction.setColumns(10);
				introduction.setBounds(183, 271, 153, 24);
				panel.add(introduction);
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
						//��ȡ�ַ���
						String idstring = ID.getText().trim();
						String namestring = name.getText().trim();
						String autherstring = auther.getText().trim();
						String pricestring = price.getText().trim();
						String typestring = type.getText().trim();
						String intrstring = introduction.getText().trim();
						//��װ
						Book_info newb = new Book_info();
						  newb.setBook_id(idstring);
		            	  newb.setBook_name(namestring);
		            	  newb.setBook_auther(autherstring);
		            	  newb.setBook_price(Double.parseDouble(pricestring) );//�ַ���תΪdouble
		            	  newb.setBook_type(typestring);
		            	  newb.setBook_introdution(intrstring);
		            	  
		            	//�������ݿ�
							DatabaseConnection dc = new DatabaseConnection();
							Connection conn = dc.getConnection();
							
							Book_infoDao bd = new Book_infoDaoImpl(conn);
							
									
										boolean doupdate = bd.doupdate(newb);
										if(doupdate) {
											String message = "�޸ĳɹ�!";
											//ѭ���滻
											for(int j=0;j<ManagerMenu.ALLlist.size();j++) {
												if(newb.getBook_id().equals(ManagerMenu.ALLlist.get(j).getBook_id())) {
													Collections.replaceAll(ManagerMenu.ALLlist,ManagerMenu.ALLlist.get(j),newb); //��list�е�list.get(j)ʹ��ss������  
												}
									}
											JOptionPane.showMessageDialog(contentPanel, message );
										}else {
											String message = "�޸�ʧ��!";
											JOptionPane.showMessageDialog(contentPanel, message );
										}
				
							dc.close();//�ر���Դ
							ID.setText("");
							name.setText("");
							auther.setText("");
							price.setText("");
							type.setText("");
							introduction.setText("");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("����");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
						
						ID.setText("");
						name.setText("");
						auther.setText("");
						price.setText("");
						type.setText("");
						introduction.setText("");
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
