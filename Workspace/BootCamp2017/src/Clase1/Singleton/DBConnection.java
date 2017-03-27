package Clase1.Singleton;

public class DBConnection {
	
	private static DBConnection instance = null;
	private DBConnection() {
	}
	static public DBConnection getInstance(){
		if(instance == null){
			instance = new DBConnection();
		}
		return instance;
	}
}
