package Clase1.AbstractFactory;

import Clase1.AbstractFactory.Connections.Connection;
import Clase1.AbstractFactory.Connections.ConnectionMariaDB;
import Clase1.AbstractFactory.Connections.ConnectionMySQL;

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
