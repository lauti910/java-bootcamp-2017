package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments;

public class Counter {
	
	private static Counter instance;
	private static Integer lastIdUsed;
	
	private Counter(){
	}
	
	public static Counter getInstance(){
		if(instance == null){
			instance = new Counter();
			lastIdUsed = 0;
			
		}
		return instance;
	}
	
	public synchronized Integer getIdentification(){
		lastIdUsed += 1;
		return lastIdUsed;
		
	}
}
