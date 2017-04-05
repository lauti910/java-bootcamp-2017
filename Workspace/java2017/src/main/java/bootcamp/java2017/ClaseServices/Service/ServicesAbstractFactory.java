package bootcamp.java2017.ClaseServices.Service;


public class ServicesAbstractFactory {
	
	public UserServiceFactory getUserServiceFactory(){
		return new UserServiceFactory();
	}
	public ShoppingCartServiceFactory getShoppingCartServiceFactory(){
		return new ShoppingCartServiceFactory();
	}
}
