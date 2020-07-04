package cn.kangz.pojo;

public class Manager {
	private String manager_id;
	private String manager_password;
	private String manager_phonenumber;
	private String manager_email;
	
	public Manager(String manager_id, String manager_password, String manager_phonenumber, String manager_email) {
		super();
		this.manager_id = manager_id;
		this.manager_password = manager_password;
		this.manager_phonenumber = manager_phonenumber;
		this.manager_email = manager_email;
	}
	
	public Manager() {
		super();
	}
	
	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getManager_password() {
		return manager_password;
	}

	public void setManager_password(String manager_password) {
		this.manager_password = manager_password;
	}

	public String getManager_phonenumber() {
		return manager_phonenumber;
	}

	public void setManager_phonenumber(String manager_phonenumber) {
		this.manager_phonenumber = manager_phonenumber;
	}

	public String getManager_email() {
		return manager_email;
	}

	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}

	public Manager(String manager_id, String manager_password) {
		super();
		this.manager_id = manager_id;
		this.manager_password = manager_password;
	}
	
	
	
}
