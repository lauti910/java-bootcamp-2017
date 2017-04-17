package bootcamp.java2017.FinalProyect.ServiceImpl.ShoppingCart;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.java2017.FinalProyect.DAO.CartDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.CartDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.HibernateSession;
import bootcamp.java2017.FinalProyect.DAOImpl.OffersDAOImpl;
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
	private HibernateSession session;
	public ShoppingCartImpl() {
		this.dao = new CartDAOImpl();
		this.session = HibernateSession.getInstance();
	}
	
	@Override
	public void addItem(Item item, Integer cartId) {
		this.session.openCurrentSessionwithTransaction();
		
		Cart cart = this.dao.getCart(cartId);
		cart.addItem(item);
		this.dao.update(cart);
		
		this.session.closeCurrentSessionwithTransaction();
	}

	@Override
	public void removeItem(Item item, Integer cartId) throws ItemNotFoundException {
		this.session.openCurrentSessionwithTransaction();
		
		Cart cart = this.dao.getCart(cartId);
		cart.removeItem(item);
		this.dao.update(cart);
		
		this.session.closeCurrentSessionwithTransaction();
		
	}

	@Override
	public Double getTotalPrice(Integer cartId) {
		this.session.openCurrentSessionwithTransaction();
		
		Cart cart = this.dao.getCart(cartId);

		this.session.closeCurrentSessionwithTransaction();
		
		return cart.getTotalPrice();
		
	}

	@Override
	public Double getActualPrice(Integer cartId) {
		this.session.openCurrentSessionwithTransaction();
		
		Cart cart = this.dao.getCart(cartId);
		List<Offer> offers = new OffersDAOImpl().getAll();

		this.session.closeCurrentSessionwithTransaction();
		
		return cart.getActualPrice(offers);
		
	}

	@Override
	public void setFormOfPayment(FormOfPayment payment, Integer cartId) {
		this.session.openCurrentSessionwithTransaction();
		
		Cart cart = this.dao.getCart(cartId);
		cart.setFormOfPayment(payment);
		this.dao.update(cart);

		this.session.closeCurrentSessionwithTransaction();

	}

	@Override
	public ItemList getItems(Integer cartId) {
		this.session.openCurrentSessionwithTransaction();
		
		Cart cart = this.dao.getCart(cartId);

		this.session.closeCurrentSessionwithTransaction();
		
		return cart.getItems();
	}

	@Override
	public Ticket pay(Integer cartId) throws NotEnoughMoneyException {
		this.session.openCurrentSessionwithTransaction();
		
		Cart cart = this.dao.getCart(cartId);
		Ticket ticket = cart.pay(this.getActualPrice(cartId));
		this.dao.update(cart);

		this.session.closeCurrentSessionwithTransaction();
		
		return ticket;

	}

	@Override
	public Integer getCartIdOfTheUser(User user) {
		this.session.openCurrentSessionwithTransaction();
		
		Integer cartId = this.dao.getCartByUserId(user.getId()).getId();
		
		this.session.closeCurrentSessionwithTransaction();
		
		return cartId;
	}

}
