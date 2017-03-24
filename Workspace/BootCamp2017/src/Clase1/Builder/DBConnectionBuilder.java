package Clase1.Builder;

import Clase1.Singleton.Connection;

public interface DBConnectionBuilder {
	
	public void buildDriver();
	public void buildConnectionString();
	public Connection getConnection();
}
