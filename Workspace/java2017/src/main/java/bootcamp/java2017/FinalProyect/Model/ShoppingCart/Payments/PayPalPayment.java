package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;


public class PayPalPayment implements FormOfPayment{


	@Override
	public Ticket pay(User user, Double price, ItemList items) throws NotEnoughMoneyException {
		String email = user.getEmail();
		String pass = user.getPassword(); //TODO: this is insecure, find another way
		PaypalAccount paypal = new PaypalAccount(email,pass);
		Double actualPrice = price;
		if(!items.isEmpty()){
			actualPrice = price - items.getCheapestItem().getPrice();
		}
		paypal.spend(actualPrice);
		return new Ticket(items, price, actualPrice, "Paypal");
		
	}

}
