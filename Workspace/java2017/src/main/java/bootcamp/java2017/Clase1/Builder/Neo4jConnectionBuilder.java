package bootcamp.java2017.Clase1.Builder;

import bootcamp.java2017.Clase1.Singleton.DBConnection;

public class Neo4jConnectionBuilder implements DBConnectionBuilder{

	public void buildDriver() {
		//builds the driver for Neo4j
	}

	public void buildConnectionString() {
		//builds the string for the driver
		
	}

	public DBConnection getConnection() {
		//returns the connection
		return DBConnection.getInstance();
	}
	
}
