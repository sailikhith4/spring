package dsi.poc.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="order_details")
public class OrderEntity {

	@Id	
	@GeneratedValue
	private long order_id;
	
	@NotEmpty(message = "Please provide item-name!")
	private String item_name;

	@NotNull(message = "please provide a mobile-number!")
	private long mobile_no;
	
	@Email
	@NotEmpty(message = "Please provide a mail_id!")
	private String mail_id;
	
	@NotEmpty(message = "Please provide a name!")
	private String customer_name;

	public OrderEntity() {}

	public OrderEntity(long order_id, @NotEmpty(message = "Please provide item-name!") String item_name,
			@NotNull(message = "please provide a mobile-number!") long mobile_no,
			@Email @NotEmpty(message = "Please provide a mail_id!") String mail_id,
			@NotEmpty(message = "Please provide a name!") String customer_name) {
		super();
		this.order_id = order_id;
		this.item_name = item_name;
		this.mobile_no = mobile_no;
		this.mail_id = mail_id;
		this.customer_name = customer_name;
	}
	@Override
	public String toString() {
		return "OrderEntity [order_id=" + order_id + ", item_name=" + item_name + ", mobile_no=" + mobile_no
				+ ", mail_id=" + mail_id + ", customer_name=" + customer_name + "]";
	}
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	





}
