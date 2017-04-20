package bootcamp.java2017.DAO;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bootcamp.java2017.FinalProyect.DAO.OffersDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.OffersDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.Session.Runner;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Category;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Offer.Offer;

public class OfferDAOTest {
	
	private OffersDAO dao;
	private Offer offer;
	private Offer offer2;
	private Offer offer3;
	private Offer offer4;
	private Item item;
	
	@Before
	public void setUp(){
		this.dao = new OffersDAOImpl();
		this.item = new Item(100.0, "apple", Category.FRUIT);
		this.offer = new Offer("a", 1.0, this.item);
		this.offer2 = new Offer("aa", 2.0, this.item);
		this.offer3 = new Offer("aaa", 3.0, this.item);
		this.offer4 = new Offer("aaaa", 4.0, this.item);
		
		
		this.offer3.setOffer(offer4);
		this.offer2.setOffer(offer3);
	}
	
	@Test
	public void test_AnOfferIsPersisted(){
		Runner.runInSession(() ->{
			this.dao.persist(offer);
			assertEquals(this.dao.getOffer(offer.getId()).getName(), offer.getName());
			this.dao.remove(offer);
			return null;
		});
	}
	@Test
	public void test_GetAllOffersReturnsAllTheOffersInTheDatabase_ButNotTheOnesThatAreInsideOthers(){
		Runner.runInSession(() ->{
			this.dao.persist(offer);
			this.dao.persist(offer2);
			List<Offer> offers = this.dao.getAll();
			
			
			assertEquals(offers.size(), 2);
			assertEquals(offers.get(0).getName(), offer.getName() );
			assertEquals(offers.get(1).getName(), offer2.getName() );
			assertTrue(offers.get(1).contains(offer3));
			assertTrue(offers.get(1).contains(offer4));
			
			this.dao.remove(offer);
			this.dao.remove(offer2);
			return null;
		});
	}
	@Test
	public void test_AnOfferIsRemoved(){
		Runner.runInSession(() ->{
			this.dao.persist(offer2);
			this.dao.remove(offer2);
			assertTrue(this.dao.getAll().isEmpty());
			return null;
		});
	}
	@Test
	public void test_AnOfferIsUpdated(){
		Runner.runInSession(() ->{
			this.dao.persist(offer);
			this.dao.persist(offer2);
			
			offer.setOffer(offer2);
			this.dao.update(offer);
			
			assertEquals(this.dao.getAll().size(), 1);
			
			this.dao.remove(offer);
			return null;
		});
	}
}
