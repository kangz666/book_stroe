package cn.kangz.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.kangz.dao.Book_infoDao;
import cn.kangz.dbc.DatabaseConnection;
import cn.kangz.impl.Book_infoDaoImpl;
import cn.kangz.pojo.Book_info;

public class AddJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField ID;
	private JTextField name;
	private JTextField auther;
	private JTextField price;
	private JTextField type;
	private JTextField introduction;
	private static AddJDialog dialog = null;
	//ÿ��ֻ�й��������ע��������оͲ��ٴ������� ֻ����һ���������
			public static synchronized AddJDialog getInstance() {
				if(dialog==null) {
					dialog= new AddJDialog();
				}
				return dialog;
			}
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			AddJDialog dialog = new AddJDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public AddJDialog() {
		setTitle("\u6DFB\u52A0\u56FE\u4E66");
		setBounds(100, 100, 450, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("ͼ����");
			lblNewLabel.setBounds(77, 13, 72, 18);
			panel.add(lblNewLabel);
			
			ID = new JTextField();
			ID.setBounds(174, 10, 150, 24);
			panel.add(ID);
			ID.setColumns(10);
			
			name = new JTextField();
			name.setColumns(10);
			name.setBounds(174, 55, 150, 24);
			panel.add(name);
			
			JLabel lblNewLabel_1 = new JLabel("����");
			lblNewLabel_1.setBounds(77, 58, 72, 18);
			panel.add(lblNewLabel_1);
			
			auther = new JTextField();
			auther.setColumns(10);
			auther.setBounds(174, 99, 150, 24);
			panel.add(auther);
			
			JLabel lblNewLabel_2 = new JLabel("����");
			lblNewLabel_2.setBounds(77, 102, 72, 18);
			panel.add(lblNewLabel_2);
			
			price = new JTextField();
			price.setColumns(10);
			price.setBounds(174, 147, 150, 24);
			panel.add(price);
			
			JLabel lblNewLabel_3 = new JLabel("�۸�");
			lblNewLabel_3.setBounds(77, 150, 72, 18);
			panel.add(lblNewLabel_3);
			
			type = new JTextField();
			type.setColumns(10);
			type.setBounds(174, 197, 150, 24);
			panel.add(type);
			
			JLabel lblNewLabel_4 = new JLabel("����");
			lblNewLabel_4.setBounds(77, 200, 72, 18);
			panel.add(lblNewLabel_4);
			
			introduction = new JTextField();
			introduction.setColumns(10);
			introduction.setBounds(174, 245, 150, 24);
			panel.add(introduction);
			
			JLabel lblNewLabel_5 = new JLabel("���");
			lblNewLabel_5.setBounds(77, 248, 72, 18);
			panel.add(lblNewLabel_5);
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
						Book_info b = new Book_info();
						  b.setBook_id(idstring);
		            	  b.setBook_name(namestring);
		            	  b.setBook_auther(autherstring);
		            	  b.setBook_price(Double.parseDouble(pricestring) );//�ַ���תΪdouble
		            	  b.setBook_type(typestring);
		            	  b.setBook_introdution(intrstring);
		            	  
		            	//�������ݿ�
							DatabaseConnection dc = new DatabaseConnection();
							Connection conn = dc.getConnection();
							
							Book_infoDao bd = new Book_infoDaoImpl(conn);
							//ͼ���Ƿ��Ѿ�����
							if(! b.equals(bd.doselectname(namestring))) {
									if(!b.equals(bd.doselectid(idstring))){
										boolean doinsert = bd.doinsert(b);
										if(doinsert) {
											String message = "��ӳɹ�!";
											ManagerMenu.ALLlist.add(b);
											JOptionPane.showMessageDialog(contentPanel, message );
										}else {
											String message = "���ʧ��!";
											JOptionPane.showMessageDialog(contentPanel, message );
										}
								
									}else {
										String message = "��ͼ�����Ѵ��ڣ�";
										JOptionPane.showMessageDialog(contentPanel, message );
									}
							}else {
								String message = "��ͼ�����Ѵ��ڣ�";
								JOptionPane.showMessageDialog(contentPanel, message );
							}
							
							dc.close();//�ر���Դ
//							ID.setText("");
//							name.setText("");
//							auther.setText("");
//							price.setText("");
//							type.setText("");
//							introduction.setText("");
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
