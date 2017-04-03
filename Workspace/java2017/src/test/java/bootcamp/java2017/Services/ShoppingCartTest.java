package bootcamp.java2017.Services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bootcamp.java2017.Services.Exceptions.ItemNotFoundException;
import bootcamp.java2017.Services.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.Services.ShoppingCart.ItemList;
import bootcamp.java2017.Services.ShoppingCart.ShoppingCartImpl;
import bootcamp.java2017.Services.ShoppingCart.Interfaces.FormOfPayment;
import bootcamp.java2017.Services.ShoppingCart.Interfaces.Item;
import bootcamp.java2017.Services.ShoppingCart.Interfaces.ShoppingCartAPI;
import bootcamp.java2017.Services.ShoppingCart.Payments.CashPayment;
import bootcamp.java2017.Services.ShoppingCart.Payments.PayPalPayment;
import bootcamp.java2017.Services.UserService.User;

public class ShoppingCartTest {

	private ShoppingCartAPI cart;
	private Item item;

	@Before
	public void setUp() {
		this.cart = new ShoppingCartImpl();
		this.item = Mockito.mock(Item.class);
	}

	@Test
	public void test_ANewShoppingCartHasAnEmptyListOfItems() {
		assertTrue(this.cart.getItems().isEmpty());
	}

	@Test
	public void test_AShoppingCartWithAnItem_ContainsThatItemInTheList() {
		this.cart.addItem(this.item);

		assertTrue(this.cart.getItems().contains(this.item));
		assertFalse(this.cart.getItems().isEmpty());
	}

	@Test
	public void test_IfYouRemoveAnItemFromTheCart_ItIsNoMoreInTheList() {
		this.cart.addItem(this.item);

		try {
			this.cart.removeItem(this.item);

		} catch (ItemNotFoundException e) {
			fail("No se agrego el item para poder removerlo");
		}

		assertFalse(this.cart.getItems().contains(this.item));
	}

	@Test(expected = ItemNotFoundException.class)
	public void test_WhenYouTryToRemoveAnItemThatIsntInTheCart_ItTrowsAnException() throws ItemNotFoundException {
		this.cart.removeItem(this.item);
	}

	@Test
	public void test_WhenYouAddAnItem_ItsPriceIsAddedToTheTotalPrice() {
		Mockito.stub(this.item.getPrice()).toReturn(new Double(10));
		
		this.cart.addItem(this.item);
		
		assertEquals(this.cart.getTotalPrice(),new Double(10));
	}
	
	 @Test
	 public void test_WhenYouPay_TheCartIsEmpty() throws NotEnoughMoneyException{
		 this.cart.addItem(this.item);
		 
		 this.cart.pay(Mockito.mock(User.class));
		 
		 assertTrue(this.cart.getItems().isEmpty());
	 }
	 
	 @Test(expected= NotEnoughMoneyException.class)
	 public void test_WhenYouPayWithAnotherMethodThanCash_ButHaventEnoughMoney_AnExeptionIsTrown() throws NotEnoughMoneyException{
		 FormOfPayment paypal = Mockito.mock(PayPalPayment.class);
		 Mockito.doThrow(NotEnoughMoneyException.class).when(paypal).pay(Mockito.any(User.class), Mockito.anyDouble(), Mockito.any(ItemList.class));
		 User user = Mockito.mock(User.class);

		 this.cart.setFormOfPayment(paypal);
		 this.cart.pay(user);
		 
	 }

}
