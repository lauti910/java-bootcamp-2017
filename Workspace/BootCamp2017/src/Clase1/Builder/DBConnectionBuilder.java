package Clase1.Builder;

import Clase1.Singleton.DBConnection;

public interface DBConnectionBuilder {
	
	public void buildDriver();
	public void buildConnectionString();
	public DBConnection getConnection();
}
