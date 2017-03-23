package Clase1.AbstractFactory;

public abstract class AbstractDBConnectionFactory {
	abstract ConnectionA getConnectionA();
	abstract ConnectionB getConnectionB();
}
