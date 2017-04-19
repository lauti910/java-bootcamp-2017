package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="item")
public class Item{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Double price;
	private String name;
	@Enumerated(value=EnumType.STRING)
	private Category category;
	
	protected Item(){}
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
	@JsonIgnore
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public Category getCategory() {
		return this.category;
	}

}
