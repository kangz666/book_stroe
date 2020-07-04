package cn.kangz.pojo;
/**
 * 这是用户会员的账号密码类
 * @author kz
 *
 */
public class User {
	

	private String username; //用户名
	private String password;//密码
	private String name;//姓名
	private String iphonenumber;//电话号码
	private String address;//地址
	
	
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
		return " [账号=" + username + ",密码=" + password + ",真实姓名=" + name + ",手机号码="
				+ iphonenumber + ",地址=" + address + "]";
	}
	
	
}
