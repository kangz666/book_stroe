package cn.kangz.pojo;
/**
 * �����û���Ա���˺�������
 * @author kz
 *
 */
public class User {
	

	private String username; //�û���
	private String password;//����
	private String name;//����
	private String iphonenumber;//�绰����
	private String address;//��ַ
	
	
	public User(String username, String password, String name, String iphonenumber, String address) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.iphonenumber = iphonenumber;
		this.address = address;
	}

	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public User() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIphonenumber() {
		return iphonenumber;
	}
	public void setIphonenumber(String iphonenumber) {
		this.iphonenumber = iphonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return " [�˺�=" + username + ",����=" + password + ",��ʵ����=" + name + ",�ֻ�����="
				+ iphonenumber + ",��ַ=" + address + "]";
	}
	
	
}
