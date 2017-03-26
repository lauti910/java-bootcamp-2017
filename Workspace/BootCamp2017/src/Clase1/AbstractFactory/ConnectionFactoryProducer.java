package Clase1.AbstractFactory;

public class ConnectionFactoryProducer {
	
	public static AbstractDBConnectionFactory getFactory(String choise){
		if(choise.equalsIgnoreCase("SQL")){
			return new SQLConnectionFactory();
		}
		if(choise.equalsIgnoreCase("NoSQL")){
			return new NoSQLConnectionFactory();
		}
		else{
			return null;
		}
	}

}
