package bootcamp.java2017.Services.ShoppingCart.Offers;

import java.util.ArrayList;
import java.util.List;

import bootcamp.java2017.Services.ShoppingCart.Items.Item;
import bootcamp.java2017.Services.ShoppingCart.Items.ItemList;
import bootcamp.java2017.Services.ShoppingCart.Items.ItemListImpl;

public class Offer {
	
	private String name;
	private Double price;
	private List<Item> items;
	private List<Offer> offers;
	
	public Offer(String name, Double price){
		this.name = name;
		this.price = price;
		this.items = new ArrayList<Item>();
		this.offers = new ArrayList<Offer>();
	}
	public void addItem(Item item){
		this.items.add(item);
	}
	public void removeItem(Item item){
		this.items.remove(item);
	}
	public Boolean canBeApplied(ItemList itemList){
		Boolean result = false;
		for(Offer of: this.offers){
			result = result || of.canBeApplied(itemList);
		}
		return result || this.items.stream().allMatch(item -> itemList.contains(item));
	}
	
	public void show(){
		System.out.println(this.name + "...... $" + this.price);
		new ItemListImpl(this.items).show();
		for(Offer of: this.offers){
			of.show();
		}
	}
	
	public Double getPrice(){
		return this.price;
	}
	
	public String getName(){
		return this.name;
	}
	
}
