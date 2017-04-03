package bootcamp.java2017.Services.ShoppingCart;

import java.util.List;

import bootcamp.java2017.Services.ShoppingCart.Interfaces.Item;

public class Offer {
	
	private String name;
	private Double price;
	private List<Item> items;
	
	public Offer(String name, Double price){
		this.name = name;
		this.price = price;
	}
	public void addItem(Item item){
		this.items.add(item);
	}
	public void removeItem(Item item){
		this.items.remove(item);
	}
	public Boolean canBeApplied(ItemList itemList){
		return this.items.stream().allMatch(item -> itemList.contains(item));
	}
	
	public void show(){
		
	}
	
	public Double getPrice(){
		return this.price;
	}
	
	public String getName(){
		return this.name;
	}
	
}
