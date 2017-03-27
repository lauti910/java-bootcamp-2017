package bootcamp.java2017.Clase1.AbstractFactory;

import bootcamp.java2017.Clase1.AbstractFactory.Connections.Connection;

public abstract class AbstractDBConnectionFactory {
	abstract Connection getConnection(String type);
}
