package bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments;

import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemList;

public class Ticket {
	
	private ItemList items;
	private Double totalPrice;
	private Double actualPrice;
	private String formOfPayment;
	private Integer identificator;
	
	public Ticket(ItemList items, Double totalPrice, Double actualPriceWithDiscounts, String formOfPayment){
		this.items = items;
		this.totalPrice = totalPrice;
		this.actualPrice = actualPriceWithDiscounts;
		this.formOfPayment = formOfPayment;
		this.identificator = Counter.getInstance().getIdentification();
	}
	
	public void print(){
		items.show();
		System.out.println("------");
		System.out.println("Total price: " + this.totalPrice);
		System.out.println("Discounts because paying in " + this.formOfPayment + ": " + (this.totalPrice - this.actualPrice));
		System.out.println("Actual price " + this.actualPrice);
		System.out.println("Unique transaction Id: " + this.identificator);
	}

	public Double getActualPrice() {
		return this.actualPrice;
	}
}
