package Clase1.Builder;

import Clase1.Singleton.Connection;

public class Neo4jConnectionBuilder implements DBConnectionBuilder{

	@Override
	public void buildDriver() {
		//builds the driver for Neo4j
	}

	@Override
	public void buildConnectionString() {
		//builds the string for the driver
		
	}

	@Override
	public Connection getConnection() {
		//returns the connection
		return new Connection();
	}
	
}
