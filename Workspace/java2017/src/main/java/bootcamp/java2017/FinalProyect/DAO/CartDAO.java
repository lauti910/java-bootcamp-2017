package bootcamp.java2017.FinalProyect.DAO;

import java.util.Optional;

import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;

public interface CartDAO {
	
	public Optional<Cart> getCart(Integer cartId);
	public Optional<Cart> getCartByUserId(Integer userId);
	
	public void persist(Cart cart);
	
	public void update(Cart cart);
	
	public void remove(Cart cart);
	
}
