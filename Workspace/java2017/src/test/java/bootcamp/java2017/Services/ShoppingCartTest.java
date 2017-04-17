package bootcamp.java2017.Services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import bootcamp.java2017.FinalProyect.DAOImpl.HibernateSession;
import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.PayPalPayment;
import bootcamp.java2017.FinalProyect.Service.ShoppingCart.ShoppingCartAPI;
import bootcamp.java2017.FinalProyect.ServiceImpl.ShoppingCart.ShoppingCartImpl;

public class ShoppingCartTest {

	private ShoppingCartImpl cart;
	private HibernateSession session;
	private Item item;

	@Before
	public void setUp() {
		
		this.cart = new ShoppingCartImpl();
		this.session = Mockito.spy(HibernateSession.getInstance());
		this.item = Mockito.mock(Item.class);
		Mockito.doReturn(null).when(this.session).openCurrentSessionwithTransaction();
		Mockito.doNothing().when(this.session).closeCurrentSessionwithTransaction();
	}

	@Test
	public void test_ANewShoppingCartHasAnEmptyListOfItems() {
		assertTrue(this.cart.getItems(0).isEmpty());
	}

	@Test
	public void test_AShoppingCartWithAnItem_ContainsThatItemInTheList() {
		this.cart.addItem(this.item,0);

		assertTrue(this.cart.getItems(0).contains(this.item));
		assertFalse(this.cart.getItems(0).isEmpty());
	}

	@Test
	public void test_IfYouRemoveAnItemFromTheCart_ItIsNoMoreInTheList() {
		this.cart.addItem(this.item,0);

		try {
			this.cart.removeItem(this.item,0);

		} catch (ItemNotFoundException e) {
			fail("No se agrego el item para poder removerlo");
		}

		assertFalse(this.cart.getItems(0).contains(this.item));
	}

	@Test(expected = ItemNotFoundException.class)
	public void test_WhenYouTryToRemoveAnItemThatIsntInTheCart_ItTrowsAnException() throws ItemNotFoundException {
		this.cart.removeItem(this.item,0);
	}

	@Test
	public void test_WhenYouAddAnItem_ItsPriceIsAddedToTheTotalPrice() {
		Mockito.stub(this.item.getPrice()).toReturn(new Double(10));
		
		this.cart.addItem(this.item,0);
		
		assertEquals(this.cart.getTotalPrice(0),new Double(10));
	}
	
	 @Test
	 public void test_WhenYouPay_TheCartIsEmpty() throws NotEnoughMoneyException{
		 this.cart.addItem(this.item,0);
		 
		 this.cart.pay(0);
		 
		 assertTrue(this.cart.getItems(0).isEmpty());
	 }
	 
	 @Test(expected= NotEnoughMoneyException.class)
	 public void test_WhenYouPayWithAnotherMethodThanCash_ButHaventEnoughMoney_AnExeptionIsTrown() throws NotEnoughMoneyException{
		 FormOfPayment paypal = Mockito.mock(PayPalPayment.class);
		 Mockito.doThrow(NotEnoughMoneyException.class).when(paypal).pay(Mockito.any(User.class), Mockito.anyDouble(), Mockito.any(ItemList.class));
		 User user = Mockito.mock(User.class);

		 this.cart.setFormOfPayment(paypal,0);
		 this.cart.pay(0);
		 
	 }

}
