package bootcamp.java2017.Services.ShoppingCart.Interfaces;

import bootcamp.java2017.Services.ShoppingCart.Exceptions.NotEnoughMoneyException;

public interface FormOfPayment {
	public void pay() throws NotEnoughMoneyException;
}
