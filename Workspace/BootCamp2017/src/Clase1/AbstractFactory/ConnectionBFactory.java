package Clase1.AbstractFactory;

public class ConnectionBFactory extends AbstractDBConnectionFactory{
		
	//Should also be a singleton? i ask because it should return connection to a database

	@Override
	ConnectionA getConnectionA() {
		return null;
	}

	@Override
	ConnectionB getConnectionB() {
		return new ConnectionB();
	}

}
