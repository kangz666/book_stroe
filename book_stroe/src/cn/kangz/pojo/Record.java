package cn.kangz.pojo;

public class Record {
	
	private String Manager_id;  //管理员
	private String order_id;   //订单号
	private String type;     //操作类型
	private String date;     //操作时间
	private String money;    ///操作金额
	
	
	public Record() {
		super();
	}


	public Record(String manager_id, String order_id, String type, String date, String money) {
		super();
		Manager_id = manager_id;
		this.order_id = order_id;
		this.type = type;
		this.date = date;
		this.money = money;
	}


	public String getManager_id() {
		return Manager_id;
	}


	public void setManager_id(String manager_id) {
		Manager_id = manager_id;
	}


	public String getOrder_id() {
		return order_id;
	}


	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getMoney() {
		return money;
	}


	public void setMoney(String money) {
		this.money = money;
	}


	@Override
	public String toString() {
		return "Record [Manager_id=" + Manager_id + ", order_id=" + order_id + ", type=" + type + ", date=" + date
				+ ", money=" + money + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Manager_id == null) ? 0 : Manager_id.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Record other = (Record) obj;
		if (Manager_id == null) {
			if (other.Manager_id != null)
				return false;
		} else if (!Manager_id.equals(other.Manager_id))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
}
