package cn.kangz.pojo;

public class Shop_cart {
	
	private int shop_no;
	private String shop_id;
	private String book_id;
	private String book_name;
	private String order_sum;
	private double book_price;
	
	public Shop_cart() {
		super();
	}
	
	public Shop_cart(String shop_id, String book_id, String book_name, String order_sum, double book_price) {
		super();
		this.shop_id = shop_id;
		this.book_id = book_id;
		this.book_name = book_name;
		this.order_sum = order_sum;
		this.book_price = book_price;
	}

	public Shop_cart(int shop_no, String shop_id, String book_id, String book_name, String order_sum,
			double book_price) {
		super();
		this.shop_no = shop_no;
		this.shop_id = shop_id;
		this.book_id = book_id;
		this.book_name = book_name;
		this.order_sum = order_sum;
		this.book_price = book_price;
	}

	public int getShop_no() {
		return shop_no;
	}

	public void setShop_no(int shop_no) {
		this.shop_no = shop_no;
	}

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
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

	public double getBook_price() {
		return book_price;
	}

	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}

	@Override
	public String toString() {
		return "Shop_cart [shop_no=" + shop_no + ", shop_id=" + shop_id + ", book_id=" + book_id + ", book_name="
				+ book_name + ", order_sum=" + order_sum + ", book_price=" + book_price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
		result = prime * result + ((book_name == null) ? 0 : book_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(book_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((order_sum == null) ? 0 : order_sum.hashCode());
		result = prime * result + ((shop_id == null) ? 0 : shop_id.hashCode());
		result = prime * result + shop_no;
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
		Shop_cart other = (Shop_cart) obj;
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
		if (Double.doubleToLongBits(book_price) != Double.doubleToLongBits(other.book_price))
			return false;
		if (order_sum == null) {
			if (other.order_sum != null)
				return false;
		} else if (!order_sum.equals(other.order_sum))
			return false;
		if (shop_id == null) {
			if (other.shop_id != null)
				return false;
		} else if (!shop_id.equals(other.shop_id))
			return false;
		if (shop_no != other.shop_no)
			return false;
		return true;
	}
	
	
}
