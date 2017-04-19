package bootcamp.java2017.FinalProyect.DTO;

import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Category;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemBag;

public class ItemDTO {
	private Integer price;
	private String name;
	private Category category;
	private Integer quantity;
	
	public ItemDTO(ItemBag item){
		this.price = item.getItem().getPrice().intValue();
		this.name = item.getItem().getName();
		this.category = item.getItem().getCategory();
		this.quantity = item.getQuantity();
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
