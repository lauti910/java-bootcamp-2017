package Clase1.Proxy;

import Clase1.Singleton.Connection;
import Clase1.Singleton.DBConector;

public class ProxyDatabaseAccesor {
	private DBConector conector;
	
	public void getSomethingFromDatabase(){
		Connection con = conector.getConnection();
		con.get("something");
		con.close();
	}
}