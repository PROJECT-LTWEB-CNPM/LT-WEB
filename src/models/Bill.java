package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bills database table.
 * 
 */
@Entity
@Table(name="bills")
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bill_id")
	private String billId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name="status_bill")
	private byte statusBill;

	@Column(name="total_price")
	private int totalPrice;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="bill")
	private List<Order> orders;

	public Bill() {
	}

	public String getBillId() {
		return this.billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte getStatusBill() {
		return this.statusBill;
	}

	public void setStatusBill(byte statusBill) {
		this.statusBill = statusBill;
	}

	public int getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setBill(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setBill(null);

		return order;
	}

}