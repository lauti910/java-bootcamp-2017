package bootcamp.java2017.Clase1.AbstractFactory;

import bootcamp.java2017.Clase1.AbstractFactory.Connections.Connection;
import bootcamp.java2017.Clase1.AbstractFactory.Connections.ConnectionMongoDB;
import bootcamp.java2017.Clase1.AbstractFactory.Connections.ConnectionNeo4j;

public class NoSQLConnectionFactory extends AbstractDBConnectionFactory{

	@Override
	Connection getConnection(String type) {
		if(type.equalsIgnoreCase("MongoDB")){
			return new ConnectionMongoDB();
		}if(type.equalsIgnoreCase("Neo4j")){
			return new ConnectionNeo4j();
		}else{
			return null;
		}
	}

}
