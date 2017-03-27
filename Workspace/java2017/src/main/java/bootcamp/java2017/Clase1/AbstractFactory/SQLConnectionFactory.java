package bootcamp.java2017.Clase1.AbstractFactory;

import bootcamp.java2017.Clase1.AbstractFactory.Connections.Connection;
import bootcamp.java2017.Clase1.AbstractFactory.Connections.ConnectionMariaDB;
import bootcamp.java2017.Clase1.AbstractFactory.Connections.ConnectionMySQL;

public class SQLConnectionFactory extends AbstractDBConnectionFactory{


	@Override
	Connection getConnection(String type) {
		if(type.equalsIgnoreCase("MySQL")){
			return new ConnectionMySQL();
		}
		if(type.equalsIgnoreCase("MariaDB")){
			return new ConnectionMariaDB();
		}else{
			return null;
		}
	}

}
