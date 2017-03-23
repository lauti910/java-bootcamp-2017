package Clase1.AbstractFactory;

public class ConnectionFactoryProducer {
	
	public static AbstractDBConnectionFactory getFactory(String choise){
		if(choise.equalsIgnoreCase("A")){
			return new ConnectionAFactory();
		}
		if(choise.equalsIgnoreCase("B")){
			return new ConnectionBFactory();
		}
		else{
			return null;
		}
	}

}
