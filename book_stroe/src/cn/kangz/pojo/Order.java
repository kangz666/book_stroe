package cn.kangz.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
	private String order_id;  //订单号
	private String book_id;
	private String manager_id; //处理人
	private String username;  //用户名
	private String book_name;  //书名
	private String order_sum;  //图书数量
	private Timestamp date;        //订单时间
	private String name;  //真实姓名
	private String address;
	private String phonenumber;
	private double price;//总价格
	private String order_state; //订单状态
	private String order_remark;//备注
	
	public Order() {
		super();
	}
	
	public Order(String order_id, String book_id, String manager_id, String username, String book_name,
			String order_sum, String name, String address, String phonenumber, double price, String order_state,
			String order_remark) {
		super();
		this.order_id = order_id;
		this.book_id = book_id;
		this.manager_id = manager_id;
		this.username = username;
		this.book_name = book_name;
		this.order_sum = order_sum;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.price = price;
		this.order_state = order_state;
		this.order_remark = order_remark;
	}

	

	public Order(String order_id, String book_id, String manager_id, String username, String book_name,
			String order_sum, Date date, String name, String address, String phonenumber, double price,
			String order_state, String order_remark) {
		super();
		this.order_id = order_id;
		this.book_id = book_id;
		this.manager_id = manager_id;
		this.username = username;
		this.book_name = book_name;
		this.order_sum = order_sum;
		this.date = (Timestamp) date;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.price = price;
		this.order_state = order_state;
		this.order_remark = order_remark;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getOrder_sum() {
		return order_sum;
	}

	public void setOrder_sum(String order_sum) {
		this.order_sum = order_sum;
	}


	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}

	public String getOrder_remark() {
		return order_remark;
	}

	public void setOrder_remark(String order_remark) {
		this.order_remark = order_remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
		result = prime * result + ((book_name == null) ? 0 : book_name.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((manager_id == null) ? 0 : manager_id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((order_remark == null) ? 0 : order_remark.hashCode());
		result = prime * result + ((order_state == null) ? 0 : order_state.hashCode());
		result = prime * result + ((order_sum == null) ? 0 : order_sum.hashCode());
		result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (book_id == null) {
			if (other.book_id != null)
				return false;
		} else if (!book_id.equals(other.book_id))
			return false;
		if (book_name == null) {
			if (other.book_name != null)
				return false;
		} else if (!book_name.equals(other.book_name))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (manager_id == null) {
			if (other.manager_id != null)
				return false;
		} else if (!manager_id.equals(other.manager_id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (order_remark == null) {
			if (other.order_remark != null)
				return false;
		} else if (!order_remark.equals(other.order_remark))
			return false;
		if (order_state == null) {
			if (other.order_state != null)
				return false;
		} else if (!order_state.equals(other.order_state))
			return false;
		if (order_sum == null) {
			if (other.order_sum != null)
				return false;
		} else if (!order_sum.equals(other.order_sum))
			return false;
		if (phonenumber == null) {
			if (other.phonenumber != null)
				return false;
		} else if (!phonenumber.equals(other.phonenumber))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", book_id=" + book_id + ", manager_id=" + manager_id + ", username="
				+ username + ", book_name=" + book_name + ", order_sum=" + order_sum + ", date=" + date + ", name="
				+ name + ", address=" + address + ", phonenumber=" + phonenumber + ", price=" + price + ", order_state="
				+ order_state + ", order_remark=" + order_remark + "]";
	}
	
	
	
}
