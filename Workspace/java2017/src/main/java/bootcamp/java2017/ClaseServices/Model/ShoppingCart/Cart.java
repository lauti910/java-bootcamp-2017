package bootcamp.java2017.ClaseServices.Model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemImpl;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.CashPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.FormOfPayment;
@Entity
@Table(name= "cart")
public class Cart {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity= ItemImpl.class)
	@JoinColumn(name="item_id")
	private List<Item> items;
	
	@ManyToOne
	private FormOfPayment payment;
	
	@OneToOne
	private User user;
	
	public Cart(User user){
		this.items = new ArrayList<Item>();
		this.payment = new CashPayment();
		this.user = user;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
}
