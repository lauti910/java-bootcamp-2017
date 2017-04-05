package bootcamp.java2017.ClaseServices.Service;

import bootcamp.java2017.ClaseServices.Service.ShoppingCart.ShoppingCartAPI;
import bootcamp.java2017.ClaseServices.ServiceImpl.ShoppingCart.ShoppingCartImpl;
import bootcamp.java2017.ClaseServices.ServiceImpl.ShoppingCart.ShoppingCartProxy;
import bootcamp.java2017.ClaseServices.ServiceImpl.ShoppingCart.ShoppingCartWebImpl;

public class ShoppingCartServiceFactory {
	
	public ShoppingCartAPI getLocalService(){
		return new ShoppingCartImpl();
	}
	
	public ShoppingCartAPI getRemoteWebService(){
		return new ShoppingCartProxy(new ShoppingCartWebImpl());
	}

}
