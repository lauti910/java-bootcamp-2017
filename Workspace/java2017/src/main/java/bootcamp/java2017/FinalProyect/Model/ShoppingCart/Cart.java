package bootcamp.java2017.FinalProyect.Model.ShoppingCart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bootcamp.java2017.FinalProyect.DAOImpl.OffersDAOImpl;
import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemBag;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Offer.Offer;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.CashPayment;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.Ticket;

@Entity
@Table(name = "cart")
public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToMany(cascade = CascadeType.ALL, targetEntity = ItemBag.class)
	@JoinColumn(name = "item_bag_id")
	private List<ItemBag> items;

	@OneToOne(cascade= CascadeType.ALL, targetEntity= User.class)
	private User user;

	public Cart(User user) {
		this.items = new ArrayList<ItemBag>();
		this.user = user;
	}

	public void addItem(Item item) {
		Optional<ItemBag> opItemBag = this.getBagOfTheItem(item);
		if(opItemBag.isPresent()){
			opItemBag.get().setQuantity(opItemBag.get().getQuantity() + 1);
		}else{
			this.items.add(new ItemBag(item, 1));
		}
	}

	public void removeItem(Item item) throws ItemNotFoundException {
		//if there is no bag with the item, throw an exception.
		//if the amount of items left in the bag is 0, remove the bag
		ItemBag bag = this.getBagOfTheItem(item).orElseThrow(() -> new ItemNotFoundException());
		if(bag.getQuantity() > 1){
			bag.setQuantity(bag.getQuantity() - 1);
		}else{
			this.items.remove(bag);
		}
	}

	private Optional<ItemBag> getBagOfTheItem(Item item) {
		Optional<ItemBag> op = Optional.empty();
		for(ItemBag ib: this.items){
			if(ib.getItem().getName() == item.getName()){
				op = Optional.of(ib);
				break;
			}
		}
		return op;
	}

	public Double getTotalPrice() {
		Double sum = (double) 0;
		for(ItemBag bag: this.items){
			sum =  sum + bag.getItem().getPrice() * bag.getQuantity();
		}
		return sum;
	}

	public Double getActualPrice(List<Offer> offers) {
		Double total = this.getTotalPrice();
		ItemList itemList = this.getItems();
		List<Offer> applyableOffers =  offers.stream()
										.filter(offer -> offer.canBeApplied(itemList))
										.collect(Collectors.toList());
		Double amountSavedWithOffers = 0.0;
		for(Offer offer: applyableOffers){
			amountSavedWithOffers += offer.getPrice();
		}
		return total - amountSavedWithOffers;
	}

	public ItemList getItems() {
		return new ItemList(this.items);
	}

	public Ticket pay(Double actualPrice, FormOfPayment formOfPayment) throws NotEnoughMoneyException {
		Ticket ticket = formOfPayment.pay(user, actualPrice, this.getItems());
		
		this.items.clear();
		
		return ticket;
	}

	public Integer getId() {
		return this.id;
	}
}
