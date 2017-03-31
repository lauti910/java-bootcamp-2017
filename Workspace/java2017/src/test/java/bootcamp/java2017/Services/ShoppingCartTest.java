package bootcamp.java2017.Services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bootcamp.java2017.Services.ShoppingCart.ShoppingCartImpl;
import bootcamp.java2017.Services.ShoppingCart.Exceptions.ItemNotFoundException;
import bootcamp.java2017.Services.ShoppingCart.Interfaces.Item;
import bootcamp.java2017.Services.ShoppingCart.Interfaces.ShoppingCartAPI;

public class ShoppingCartTest {

	private ShoppingCartAPI cart;

	@Before
	public void setUp() {
		this.cart = new ShoppingCartImpl();
	}

	@Test
	public void test_ANewShoppingCartHasAnEmptyListOfItems() {
		assertTrue(this.cart.getItems().isEmpty());
	}

	@Test
	public void test_AShoppingCartWithAnItem_ContainsThatItemInTheList() {
		Item item = Mockito.mock(Item.class);
		this.cart.addItem(item);

		assertTrue(this.cart.getItems().contains(item));
		assertFalse(this.cart.getItems().isEmpty());
	}

	@Test
	public void test_IfYouRemoveAnItemFromTheCart_ItIsNoMoreInTheList() {
		Item item = Mockito.mock(Item.class);
		this.cart.addItem(item);

		assertTrue(this.cart.getItems().contains(item));

		try {
			this.cart.removeItem(item);

		} catch (ItemNotFoundException e) {
			fail("No se agrego el item para poder removerlo");
		}

		assertFalse(this.cart.getItems().contains(item));
	}

	@Test(expected = ItemNotFoundException.class)
	public void test_WhenYouTryToRemoveAnItemThatIsntInTheCart_ItTrowsAnException() throws ItemNotFoundException {
		Item item = Mockito.mock(Item.class);
		this.cart.removeItem(item);
	}

	@Test
	public void test_WhenYouAddAnItem_ItsPriceIsAddedToTheTotalPrice() {
		Item item = Mockito.mock(Item.class);
		Mockito.stub(item.getPrice()).toReturn(new Double(10));
		
		this.cart.addItem(item);
		
		assertEquals(this.cart.getTotalPrice(),new Double(10));
	}

}
