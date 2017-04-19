package bootcamp.java2017.Services;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import bootcamp.java2017.FinalProyect.DAOImpl.Session.Runner;
import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Category;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.CashPayment;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.PayPalPayment;
import bootcamp.java2017.FinalProyect.Service.ShoppingCart.ShoppingCartAPI;
import bootcamp.java2017.FinalProyect.Service.UserService.UserService;
import bootcamp.java2017.FinalProyect.ServiceImpl.ShoppingCart.ShoppingCartImpl;
import bootcamp.java2017.FinalProyect.ServiceImpl.UserService.UserServiceImpl;

public class ShoppingCartTest {

	private ShoppingCartImpl cartService;
	private UserService userService;
	private User user;
	private Cart cart;
	private Item item;
	private Integer id;

	@Before
	public void setUp() {
		this.user = new User("asd", "asd");
		this.cart = new Cart(user);
		this.cartService = new ShoppingCartImpl();
		this.userService = new UserServiceImpl();
		this.item = new Item(10.0, "asd", Category.BEVERAGE);
		this.userService.createUser(user);
		this.id = this.cartService.getCartIdOfTheUser(user);
		
	}
	
	@After
	public void after(){
		this.userService.removeUser(user);
	}
	@Test
	public void test_ANewShoppingCartHasAnEmptyListOfItems() {
		
		assertTrue(this.cartService.getItems(this.id).isEmpty());
	}

	@Test
	public void test_AShoppingCartWithAnItem_ContainsThatItemInTheList() {
		this.cartService.addItem(this.item, this.id);
		ItemList list = this.cartService.getItems(id);
		list.show();
		assertFalse(list.isEmpty());
		assertTrue(list.contains(this.item));
	}

	@Test
	public void test_IfYouRemoveAnItemFromTheCart_ItIsNoMoreInTheList() {
		this.cartService.addItem(this.item, id);

		try {
			this.cartService.removeItem(this.item, id);

		} catch (ItemNotFoundException e) {
			fail("No se agrego el item para poder removerlo");
		}

		assertFalse(this.cartService.getItems(id).contains(this.item));
	}

	@Test(expected = ItemNotFoundException.class)
	public void test_WhenYouTryToRemoveAnItemThatIsntInTheCart_ItTrowsAnException() throws ItemNotFoundException {
		this.cartService.removeItem(this.item, id);
	}

	@Test
	public void test_WhenYouAddAnItem_ItsPriceIsAddedToTheTotalPrice() {
		this.cartService.addItem(this.item ,id);
		
		assertEquals(this.cartService.getTotalPrice(id),new Double(10));
	}
	
	 @Test
	 public void test_WhenYouPay_TheCartIsEmpty() throws NotEnoughMoneyException{
		 this.cartService.addItem(this.item, id);
		 
		 this.cartService.pay(new CashPayment(), id);
		 
		 assertTrue(this.cartService.getItems(id).isEmpty());
	 }
	 
	 @Test(expected= NotEnoughMoneyException.class)
	 public void test_WhenYouPayWithAnotherMethodThanCash_ButHaventEnoughMoney_AnExeptionIsTrown() throws NotEnoughMoneyException{
		 FormOfPayment paypal = Mockito.mock(PayPalPayment.class);
		 Mockito.doThrow(NotEnoughMoneyException.class).when(paypal).pay(Mockito.any(User.class), Mockito.anyDouble(), Mockito.any(ItemList.class));
		
		 
		 this.cartService.pay(paypal, this.cartService.getCartIdOfTheUser(user));
		 
	 }

}
