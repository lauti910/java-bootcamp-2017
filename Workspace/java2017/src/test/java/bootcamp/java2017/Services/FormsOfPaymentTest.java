package bootcamp.java2017.Services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.CashPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.CreditCardPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.PayPalPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.Ticket;

public class FormsOfPaymentTest {

	private FormOfPayment paypal;
	private FormOfPayment creditCard;
	private FormOfPayment cash;
	private User user;
	private ItemList mockList;

	@Before
	public void setUp() {
		this.paypal = new PayPalPayment();
		this.creditCard = new CreditCardPayment();
		this.cash = new CashPayment();
		this.user = Mockito.mock(User.class);
		this.mockList = Mockito.mock(ItemList.class);
	}

	@Test
	public void test_WhenYouPayThroughCreditCard_ItNeedsANameAndACardNumber() throws NotEnoughMoneyException {

		this.creditCard.pay(this.user, 0.0, this.mockList);

		Mockito.verify(this.user).getName();
		Mockito.verify(this.user).getCardNumber();

	}

	@Test
	public void test_WhenYouPayThroughPaypal_ItNeedsAnEmailAndPassword() throws NotEnoughMoneyException {
		Item item = Mockito.mock(Item.class);
		Mockito.doReturn(item).when(this.mockList).getCheapestItem();
		Mockito.doReturn(0.0).when(item).getPrice();
		this.paypal.pay(this.user, 0.0, this.mockList);

		Mockito.verify(this.user).getEmail();
		Mockito.verify(this.user).getPassword();
	}

	@Test
	public void test_WhenYouPayThroughCash_NothingIsNeeded() throws NotEnoughMoneyException {
		Item item = Mockito.mock(Item.class);
		Mockito.doReturn(item).when(this.mockList).getMostExpensiveItem();
		Mockito.doReturn(0.0).when(item).getPrice();
		this.cash.pay(this.user, 0.0, this.mockList);

		Mockito.verifyZeroInteractions(this.user);
	}

	@Test
	public void test_thereIs10PercentDiscountByCreditCard() throws NotEnoughMoneyException {
		Ticket ticket = this.creditCard.pay(this.user, 100.0, this.mockList);
		
		assertEquals(new Double(90), ticket.getActualPrice());
	}
	@Test
	public void test_theCheapestItemIsFreeThroughPaypal() throws NotEnoughMoneyException{
		Item item = Mockito.mock(Item.class);
		Mockito.doReturn(item).when(this.mockList).getCheapestItem();
		Mockito.doReturn(100.0).when(item).getPrice();
		Ticket ticket = this.paypal.pay(this.user,100.0, this.mockList);
		
		assertEquals(new Double(0), ticket.getActualPrice());
	}
	@Test 
	public void test_thereIs90PercentDiscountInTheMostExpensiveItemThroughCash() throws NotEnoughMoneyException{
		Item item = Mockito.mock(Item.class);
		Mockito.doReturn(item).when(this.mockList).getMostExpensiveItem();
		Mockito.doReturn(100.0).when(item).getPrice();
		Ticket ticket = this.cash.pay(this.user, 100.0, this.mockList);
		
		assertEquals( new Double(10), ticket.getActualPrice());
	}

}
