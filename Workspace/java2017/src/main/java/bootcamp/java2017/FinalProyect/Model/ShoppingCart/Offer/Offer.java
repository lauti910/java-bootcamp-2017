package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemBag;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;

@Entity
@Table(name= "offer")
public class Offer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double price;
	@ManyToOne(cascade=CascadeType.ALL, targetEntity= Item.class)
	private Item item;
	@ManyToOne(cascade=CascadeType.ALL)
	private Offer offer;
	
	protected Offer(){}
	public Offer(String name, Double price, Item item){
		this.name = name;
		this.price = price;
		this.item = item;
	}
	public void setItem(Item item){
		this.item = item;
	}
	public Boolean canBeApplied(ItemList itemList){
		//the offer can be applied to the item list, if the list contains any of the items of the offer
		return itemList.contains(item) || this.getOffer().map(of -> of.canBeApplied(itemList)).orElse(false);
	}
	
	public void setOffer(Offer offer){
		this.offer = offer;
	}
	
	public void show(){
		System.out.println(this.name + "...... $" + this.price);
		new ItemList(this.getItems()).show();
	}
	
	private List<ItemBag> getItems() {
		List<ItemBag> items = new ArrayList<ItemBag>();
		items.add(new ItemBag(this.item, 1));
		items.addAll(this.getOffer().map(of -> of.getItems()).orElse(new ArrayList<ItemBag>()));
		return items;
	}
	public Double getPrice(){
		return this.price;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Optional<Offer> getOffer(){
		return Optional.ofNullable(this.offer);
	}
	
	public Boolean contains(Offer offer){
		//the offer i have is 'offer' or the offer i have contains 'offer'
		return this.getOffer().filter(of -> of.getId() == offer.getId()).isPresent()
				|| this.getOffer().map(of -> of.contains(offer)).orElse(false);
	}
	public Integer getId() {
		return this.id;
	}
	
}
