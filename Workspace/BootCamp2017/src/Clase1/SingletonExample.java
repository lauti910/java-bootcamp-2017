package Clase1;

public class SingletonExample {
	
	private static SingletonExample instance = null;
	private SingletonExample() {
	}
	static public SingletonExample getInstance(){
		if(instance == null){
			instance = new SingletonExample();
		}
		return instance;
	}
	
	public void getConnection(){
		//Should return a connection with a database
	}
}
