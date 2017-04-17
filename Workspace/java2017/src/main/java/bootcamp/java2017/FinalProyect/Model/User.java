package bootcamp.java2017.FinalProyect.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;
import bootcamp.java2017.FinalProyect.Service.ShoppingCart.ShoppingCartAPI;
import bootcamp.java2017.FinalProyect.ServiceImpl.ShoppingCart.ShoppingCartImpl;

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
	
	
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
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

	public Integer getId() {
		return this.id;
	}

}
