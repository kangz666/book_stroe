package cn.kangz.pojo;

public class Book_info {
	private String book_id;
	private String book_name;
	private String book_auther;
	private double book_price;
	private String book_type;
	private String book_introdution;
	/**
	 * 
	 * @param book_id
	 * @param book_name
	 * @param book_auther
	 * @param book_price
	 * @param book_type
	 * @param book_introdution
	 */
	public Book_info(String book_id, String book_name, String book_auther, double book_price,
			String book_type, String book_introdution) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_auther = book_auther;
		this.book_price = book_price;
		this.book_type = book_type;
		this.book_introdution = book_introdution;
	}
	
	
	public Book_info() {
		super();
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


	public String getBook_auther() {
		return book_auther;
	}


	public void setBook_auther(String book_auther) {
		this.book_auther = book_auther;
	}


	public String getBook_introdution() {
		return book_introdution;
	}


	public void setBook_introdution(String book_introdution) {
		this.book_introdution = book_introdution;
	}


	public double getBook_price() {
		return book_price;
	}


	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}


	public String getBook_type() {
		return book_type;
	}


	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}


	@Override
	public String toString() {
		return "Book_info [book_id=" + book_id + ", book_name=" + book_name + ", book_auther=" + book_auther
				+ ", book_introdution=" + book_introdution + ", book_price=" + book_price + ", book_type=" + book_type
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book_auther == null) ? 0 : book_auther.hashCode());
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
		result = prime * result + ((book_introdution == null) ? 0 : book_introdution.hashCode());
		result = prime * result + ((book_name == null) ? 0 : book_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(book_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((book_type == null) ? 0 : book_type.hashCode());
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
		Book_info other = (Book_info) obj;
		if (book_auther == null) {
			if (other.book_auther != null)
				return false;
		} else if (!book_auther.equals(other.book_auther))
			return false;
		if (book_id == null) {
			if (other.book_id != null)
				return false;
		} else if (!book_id.equals(other.book_id))
			return false;
		if (book_introdution == null) {
			if (other.book_introdution != null)
				return false;
		} else if (!book_introdution.equals(other.book_introdution))
			return false;
		if (book_name == null) {
			if (other.book_name != null)
				return false;
		} else if (!book_name.equals(other.book_name))
			return false;
		if (Double.doubleToLongBits(book_price) != Double.doubleToLongBits(other.book_price))
			return false;
		if (book_type == null) {
			if (other.book_type != null)
				return false;
		} else if (!book_type.equals(other.book_type))
			return false;
		return true;
	}
	
	
}
