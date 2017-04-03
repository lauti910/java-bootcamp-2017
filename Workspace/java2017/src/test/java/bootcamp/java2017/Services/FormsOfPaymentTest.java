package bootcamp.java2017.Services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bootcamp.java2017.Services.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.Services.ShoppingCart.ItemList;
import bootcamp.java2017.Services.ShoppingCart.Interfaces.FormOfPayment;
import bootcamp.java2017.Services.ShoppingCart.Interfaces.Item;
import bootcamp.java2017.Services.ShoppingCart.Payments.CashPayment;
import bootcamp.java2017.Services.ShoppingCart.Payments.CreditCardPayment;
import bootcamp.java2017.Services.ShoppingCart.Payments.PayPalPayment;
import bootcamp.java2017.Services.UserService.User;

public class FormsOfPaymentTest {
	
	private FormOfPayment paypal;
	private FormOfPayment creditCard;
	private FormOfPayment cash;
	private User user;
	private ItemList mockList;
	@Before
	public void setUp(){
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
	public void test_WhenYouPayThroughPaypal_ItNeedsAnEmailAndPassword() throws NotEnoughMoneyException{
		Item item = Mockito.mock(Item.class);
		Mockito.doReturn(item).when(this.mockList).getCheapestItem();
		Mockito.doReturn(0.0).when(item).getPrice();
		this.paypal.pay(this.user, 0.0, this.mockList);
		
		Mockito.verify(this.user).getEmail();
		Mockito.verify(this.user).getPassword();
	}
	
	@Test
	public void test_WhenYouPayThroughCash_NothingIsNeeded() throws NotEnoughMoneyException{
		Item item = Mockito.mock(Item.class);
		Mockito.doReturn(item).when(this.mockList).mostExpensiveItem();
		Mockito.doReturn(0.0).when(item).getPrice();
		this.cash.pay(this.user, 0.0, this.mockList);
		
		Mockito.verifyZeroInteractions(this.user);
	}
	
	@Test
	public void test_thereIs10PercentDiscountByCreditCard(){
		
	}

}
