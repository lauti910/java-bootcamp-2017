package bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class ItemImpl implements Item{
	
	private Double price;
	private String name;
	
	public ItemImpl(Double price, String name){
		this.price = price;
		this.name = name;
		
	}

	@Override
	public Double getPrice() {
		return this.price;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
