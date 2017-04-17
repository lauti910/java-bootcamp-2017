package bootcamp.java2017.FinalProyect.Service;

import bootcamp.java2017.FinalProyect.Service.ShoppingCart.ShoppingCartAPI;
import bootcamp.java2017.FinalProyect.ServiceImpl.ShoppingCart.ShoppingCartImpl;
import bootcamp.java2017.FinalProyect.ServiceImpl.ShoppingCart.ShoppingCartProxy;
import bootcamp.java2017.FinalProyect.ServiceImpl.ShoppingCart.ShoppingCartWebImpl;

public class ShoppingCartServiceFactory {
	
	public ShoppingCartAPI getLocalService(){
		return new ShoppingCartImpl();
	}
	
	public ShoppingCartAPI getRemoteWebService(){
		return new ShoppingCartProxy(new ShoppingCartWebImpl());
	}

}
