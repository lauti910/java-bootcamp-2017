package Clase1.Builder;

import Clase1.Singleton.DBConnection;

public class SQLConnectionBuilder implements DBConnectionBuilder{
	
	
	@Override
	public void buildDriver() {
		//builds a driver for sql
		
	}

	@Override
	public void buildConnectionString() {
		//sets the connection string for the driver
		
	}

	@Override
	public DBConnection getConnection() {
		//returns the connection
		return DBConnection.getInstance();
	}

}
