package bootcamp.java2017.Services.ShoppingCart.Payments;

import bootcamp.java2017.Services.Exceptions.NotEnoughMoneyException;

public class CreditCard {
	
	private Double money;
	
	public CreditCard(String name, Integer cardNumber) {
		this.money = 0.0;
	}

	public void pay(Double totalPrice) throws NotEnoughMoneyException {
		if(this.money - totalPrice < 0){
			throw new NotEnoughMoneyException();
		}
		this.money -= totalPrice;
	}

}
