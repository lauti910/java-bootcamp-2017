package bootcamp.java2017.FinalProyect.DAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemBag;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Offer.Offer;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.CashPayment;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.CreditCardPayment;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.PayPalPayment;

public class HibernateSession {
	
	private Session currentSession;
	private Transaction currentTransaction;
	private static HibernateSession instance;
	
	private HibernateSession(){
	}

	public static HibernateSession getInstance(){
		if(instance == null){
			instance = new HibernateSession();
		}
		return instance;
	}
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Cart.class);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Item.class);
		configuration.addAnnotatedClass(Offer.class);
		configuration.addAnnotatedClass(ItemBag.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
}
