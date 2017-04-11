package bootcamp.java2017.ClaseServices.DAO;

import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Cart;

public interface CartDAO {
	
	public Cart getCart(Integer cartId);
	public Cart getCartByUserId(Integer userId);
	
	public void persist(Cart cart);
	
	public void update(Cart cart);
	
	public void remove(Cart cart);
	
}
