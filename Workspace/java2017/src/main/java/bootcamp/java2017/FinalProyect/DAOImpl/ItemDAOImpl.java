package bootcamp.java2017.FinalProyect.DAOImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.hibernate.query.Query;

import bootcamp.java2017.FinalProyect.DAO.ItemDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.Session.Runner;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Category;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;

public class ItemDAOImpl implements ItemDAO {

	@Override
	public Optional<Item> getItemByNameAndCategory(String name, Category category) {
		return Runner.runInSession(() -> {
			Query<Item> query = Runner.getCurrentSession().createQuery("From Item i Where i.name = :name AND i.category = :category");
			query.setParameter("name", name);
			query.setParameter("category", category);
			try{
				return Optional.of(query.getSingleResult());
			}catch(NoResultException e){
				return Optional.empty();
			}
		});
	}

	@Override
	public void persist(Item item) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().persist(item);
			return null;
		});
		
	}

	@Override
	public List<Item> getItemsFromCategory(Category category) {
		return Runner.runInSession(() -> {
			Query<Item> query = Runner.getCurrentSession().createQuery("From Item I Where I.category = :category");
			query.setParameter("category", category);
			return query.getResultList();
		});
	}

	@Override
	public List<Item> getAll() {
		return Runner.runInSession(() -> {
			Query<Item> query = Runner.getCurrentSession().createQuery("From Item");
			return query.getResultList();
		});
	}

	@Override
	public void update(Item item) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().update(item);
			return null;
		});
	}

	@Override
	public void remove(Item item) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().remove(item);
			return null;
		});
	}

}
