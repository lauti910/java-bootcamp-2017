package Clase1.Builder;

import Clase1.Singleton.DBConnection;

public class DBConnectionDirector {
	
	private DBConnectionBuilder builder;
	
	public DBConnectionDirector(DBConnectionBuilder builder){
		this.builder = builder;
	}
	
	public void connect(){
		this.builder.buildConnectionString();
		this.builder.buildDriver();
	}
	public DBConnection getConnection(){
		return this.builder.getConnection();
	}

}
