package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments;

import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;

public class CreditCard {
	
	private Double money;
	
	public CreditCard(String name, Integer cardNumber) {
		this.money = 100.0; //TODO: get real money
	}

	public void pay(Double totalPrice) throws NotEnoughMoneyException {
		if(this.money - totalPrice < 0){
			throw new NotEnoughMoneyException();
		}
		this.money -= totalPrice;
	}

}
