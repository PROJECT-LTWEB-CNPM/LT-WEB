package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the options database table.
 * 
 */
@Entity
@Table(name="options")
@NamedQuery(name="Option.findAll", query="SELECT o FROM Option o")
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="option_id")
	private String optionId;

	@Column(name="available_quantity")
	private int availableQuantity;

	//bi-directional many-to-one association to Color
	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to Size
	@ManyToOne
	@JoinColumn(name="size_id")
	private Size size;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="option")
	private List<Order> orders;

	public Option() {
	}

	public String getOptionId() {
		return this.optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public int getAvailableQuantity() {
		return this.availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setOption(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setOption(null);

		return order;
	}

}