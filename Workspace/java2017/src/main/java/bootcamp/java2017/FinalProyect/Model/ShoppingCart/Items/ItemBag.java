package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "item_bag")
public class ItemBag {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer quantity;
	@ManyToOne
	private Item item;
	
	public ItemBag(Item item, Integer quantity){
		this.item = item;
		this.quantity = quantity;
	}
	
	public Item getItem(){
		return this.item;
	}
	public Integer getQuantity(){
		return this.quantity;
	}
	public void setQuantity(Integer quantity){
		this.quantity = quantity;
	}
}
