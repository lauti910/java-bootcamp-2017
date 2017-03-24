package Clase1.Singleton;

public class DBConector {
	
	private static DBConector instance = null;
	private DBConector() {
	}
	static public DBConector getInstance(){
		if(instance == null){
			instance = new DBConector();
		}
		return instance;
	}
	
	public Connection getConnection(){
		//returns a connection with a database
		return new Connection();
	}
}
