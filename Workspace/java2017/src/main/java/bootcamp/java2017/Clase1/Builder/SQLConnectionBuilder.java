package bootcamp.java2017.Clase1.Builder;

import bootcamp.java2017.Clase1.Singleton.DBConnection;

public class SQLConnectionBuilder implements DBConnectionBuilder{
	
	
	public void buildDriver() {
		//builds a driver for sql
		
	}

	public void buildConnectionString() {
		//sets the connection string for the driver
		
	}

	public DBConnection getConnection() {
		//returns the connection
		return DBConnection.getInstance();
	}

}
