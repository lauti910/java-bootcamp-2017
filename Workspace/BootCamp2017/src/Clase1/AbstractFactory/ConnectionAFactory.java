package Clase1.AbstractFactory;

public class ConnectionAFactory extends AbstractDBConnectionFactory{
	
	//Should also be a singleton? i ask because it should return connection to a database

	@Override
	ConnectionA getConnectionA() {
		return new ConnectionA();
	}

	@Override
	ConnectionB getConnectionB() {
		return null;
	}

}
