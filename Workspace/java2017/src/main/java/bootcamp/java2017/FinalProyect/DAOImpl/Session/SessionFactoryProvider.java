package bootcamp.java2017.FinalProyect.DAOImpl.Session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemBag;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Offer.Offer;

public class SessionFactoryProvider {
	
	private static SessionFactoryProvider INSTANCE;

	private SessionFactory sessionFactory;
	
	
	public static SessionFactoryProvider getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SessionFactoryProvider();
		}
		return INSTANCE;
	}
	
	public static void destroy() {
		if (INSTANCE != null && INSTANCE.sessionFactory != null) {
			INSTANCE.sessionFactory.close();
		}
		INSTANCE = null;
	}
	
	private SessionFactoryProvider() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Cart.class);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Item.class);
		configuration.addAnnotatedClass(Offer.class);
		configuration.addAnnotatedClass(ItemBag.class);
		this.sessionFactory = configuration.buildSessionFactory();
	}
	
	public Session createSession() {
		return this.sessionFactory.openSession();
	}

}
