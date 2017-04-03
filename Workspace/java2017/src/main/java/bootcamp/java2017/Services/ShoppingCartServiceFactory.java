package bootcamp.java2017.Services;

import bootcamp.java2017.Services.ShoppingCart.ShoppingCartAPI;
import bootcamp.java2017.Services.ShoppingCart.ShoppingCartImpl;
import bootcamp.java2017.Services.ShoppingCart.ShoppingCartProxy;
import bootcamp.java2017.Services.ShoppingCart.ShoppingCartWebImpl;

public class ShoppingCartServiceFactory {
	
	public ShoppingCartAPI getLocalService(){
		return new ShoppingCartImpl();
	}
	
	public ShoppingCartAPI getRemoteWebService(){
		return new ShoppingCartProxy(new ShoppingCartWebImpl());
	}

}
