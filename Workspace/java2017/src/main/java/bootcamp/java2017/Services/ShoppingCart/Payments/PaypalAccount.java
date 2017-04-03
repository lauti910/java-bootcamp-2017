package bootcamp.java2017.Services.ShoppingCart.Payments;

import bootcamp.java2017.Services.Exceptions.NotEnoughMoneyException;

public class PaypalAccount {

	private Double money;

	public PaypalAccount(String email, String pass) {
		// TODO: paypal.signIn(email,pass)
		// this.money = paypal.getMoney()
		this.money = 0.0;
	}

	public void spend(Double money) throws NotEnoughMoneyException {
		if (this.money - money < 0) {
			throw new NotEnoughMoneyException();
		}
		this.money -= money;

	}

}
