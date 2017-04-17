package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Double price;
	private String name;
	@Enumerated(value=EnumType.STRING)
	private Category category;
	
	public Item(Double price, String name, Category category){
		this.price = price;
		this.name = name;
		this.category = category;
	}

	public Double getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

}
