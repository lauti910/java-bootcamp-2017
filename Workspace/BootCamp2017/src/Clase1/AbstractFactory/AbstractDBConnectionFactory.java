package Clase1.AbstractFactory;

import Clase1.AbstractFactory.Connections.Connection;

public abstract class AbstractDBConnectionFactory {
	abstract Connection getConnection(String type);
}
