package bootcamp.java2017.Services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;

public class ItemListTest {
	
	ItemList itemList;
	List<Item> arrayList;
	Item item1;
	Item item2;
	Item item3;
	@Before
	public void setUp(){

		this.item1 = Mockito.mock(Item.class);
		this.item2 = Mockito.mock(Item.class);
		this.item3 = Mockito.mock(Item.class);
		this.arrayList = new ArrayList<Item>();
		this.arrayList.add(item1);
		this.arrayList.add(item2);
		this.arrayList.add(item3);
		this.itemList = new ItemList(this.arrayList);
		
	}

	@Test
	public void test_AnEmptyListIsEmpty_AndAListWithItemsIsnt(){
		ItemList empty = new ItemList(new ArrayList<Item>());
		
		assertTrue(empty.isEmpty());
		assertFalse(this.itemList.isEmpty());
	}

	@Test
	public void test_theListContainsItems() {
		assertTrue(this.itemList.contains(item1));
		assertTrue(this.itemList.contains(item2));
		assertTrue(this.itemList.contains(item3));
	}
	@Test
	public void test_theListKnowsWichIsTheMostExpensive_AndTheCheapest_Item(){
		Mockito.doReturn(1.0).when(item1).getPrice();
		Mockito.doReturn(20.0).when(item2).getPrice();
		Mockito.doReturn(300.0).when(item3).getPrice();
		
		assertEquals(this.itemList.getCheapestItem(), item1);
		assertEquals(this.itemList.getMostExpensiveItem(), item3);
	}

}
