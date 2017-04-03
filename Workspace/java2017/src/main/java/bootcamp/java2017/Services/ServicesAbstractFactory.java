package bootcamp.java2017.Services;

import bootcamp.java2017.Services.ShoppingCart.ShoppingCartAPI;

public class ServicesAbstractFactory {
	
	public UserServiceFactory getUserServiceFactory(){
		return new UserServiceFactory();
	}
	public ShoppingCartServiceFactory getShoppingCartServiceFactory(){
		return new ShoppingCartServiceFactory();
	}
}
