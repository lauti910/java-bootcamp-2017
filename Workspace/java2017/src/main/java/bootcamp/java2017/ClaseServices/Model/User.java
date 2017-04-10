package bootcamp.java2017.ClaseServices.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bootcamp.java2017.ClaseServices.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.ClaseServices.Service.ShoppingCart.ShoppingCartAPI;
import bootcamp.java2017.ClaseServices.ServiceImpl.ShoppingCart.ShoppingCartImpl;

@Entity
@Table(name = "user")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String password;
	private String email;
	private String fullName;
	private Integer cardNumber;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, targetEntity= ShoppingCartImpl.class)
	private ShoppingCartAPI cart;
	
	
	public User(String username, String password, ShoppingCartAPI cart){
		this.username = username;
		this.password = password;
		this.cart = cart;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}

	public String getUsername() {
		return this.username;
	}

	public String getName() {
		return this.fullName;
	}
	public void setName(String fullName){
		this.fullName = fullName;
	}
	
	public void setCardNumber(Integer cardNumber){
		this.cardNumber = cardNumber;
	}

	public Integer getCardNumber() {
		return this.cardNumber;
	}
	
	public void pay() throws NotEnoughMoneyException{
		this.cart.pay(this);
	}
	public ShoppingCartAPI getShoppingCart(){
		return this.cart;
	}

}
