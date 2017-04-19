package bootcamp.java2017.FinalProyect.ServiceImpl.ShoppingCart;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bootcamp.java2017.FinalProyect.DAO.CartDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.CartDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.OffersDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.UserDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.Session.Runner;
import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Offer.Offer;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.Ticket;
import bootcamp.java2017.FinalProyect.Service.ShoppingCart.ShoppingCartAPI;

@Service
public class ShoppingCartImpl implements ShoppingCartAPI {

	private CartDAO dao;
	public ShoppingCartImpl() {
		this.dao = new CartDAOImpl();
	}
	
	@Override
	public void addItem(Item item, Integer cartId) {
		Runner.runInSession(() -> {
			Cart cart = this.dao.getCart(cartId).get();
			cart.addItem(item);
			this.dao.update(cart);
			return null;
		});
	}

	@Override
	public void removeItem(Item item, Integer cartId) throws ItemNotFoundException{
		
		Runner.runInSession(() -> {
			Cart cart = this.dao.getCart(cartId).get();
			cart.removeItem(item);
			this.dao.update(cart);
			return null;
		});
		
	}

	@Override
	public Double getTotalPrice(Integer cartId) {
		return Runner.runInSession(() -> {
			Cart cart = this.dao.getCart(cartId).get();
			return cart.getTotalPrice();
		});
	}

	@Override
	public Double getActualPrice(Integer cartId) {
		return Runner.runInSession(() -> {
			Cart cart = this.dao.getCart(cartId).get();
			List<Offer> offers = new OffersDAOImpl().getAll();
			
			return cart.getActualPrice(offers);
		});
		
		
		
	}

	@Override
	public ItemList getItems(Integer cartId) {
		return Runner.runInSession(() -> {

			Cart cart = this.dao.getCart(cartId).get();
			
			return cart.getItems();
		});
	}

	@Override
	public Ticket pay(FormOfPayment formOfPayment, Integer cartId) throws NotEnoughMoneyException {
		return Runner.runInSession(() -> {
			System.out.println("get cart with id:" + cartId);
			Cart cart = this.dao.getCart(cartId).get();
			Ticket ticket = cart.pay(this.getActualPrice(cartId), formOfPayment);
			this.dao.update(cart);
			
			return ticket;
		});
		

	}

	@Override
	public Integer getCartIdOfTheUser(User user) {
		return Runner.runInSession(() -> {
			Optional<Cart> opCart = this.dao.getCartByUserId(user.getId());
			if( !opCart.isPresent()){
				Cart cart = new Cart(user);
				opCart = Optional.of(cart);
				this.dao.persist(cart);
				
				System.out.println("Created cart with ID:" + opCart.get().getId());
			}
			return opCart.get().getId();
		});
	}

}
