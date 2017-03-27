package bootcamp.java2017.Clase1.Builder;

import bootcamp.java2017.Clase1.Singleton.DBConnection;

public interface DBConnectionBuilder {
	
	public void buildDriver();
	public void buildConnectionString();
	public DBConnection getConnection();
}
