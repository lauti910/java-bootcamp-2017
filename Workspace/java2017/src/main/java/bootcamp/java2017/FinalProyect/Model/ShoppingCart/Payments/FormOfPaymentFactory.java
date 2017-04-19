package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments;

public class FormOfPaymentFactory {
	
	public FormOfPayment getFormOfPayment(Payments name){
		if(name == Payments.PAYPAL) {
			return new PayPalPayment();
		}
		if(name == Payments.CREDITCARD){
			return new CreditCardPayment();
		}
		else{
			return new CashPayment();
		}
	}
}
