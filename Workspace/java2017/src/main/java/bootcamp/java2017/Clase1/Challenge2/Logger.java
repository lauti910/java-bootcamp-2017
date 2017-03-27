package bootcamp.java2017.Clase1.Challenge2;


import bootcamp.java2017.Clase1.Challenge2.Lenguages.LoggerLenguage;
import bootcamp.java2017.Clase1.Challenge2.Operations.Operation;

public class Logger implements OperationObserver{
	
	private LoggerLenguage lenguage;
	public Logger(LoggerLenguage lenguage){
		this.lenguage = lenguage;
	}
	@Override
	public void update(Operation operation) {
		
		this.lenguage.log(operation.getQuery());
		
	}
	
	public void setLenguage(LoggerLenguage leng){
		this.lenguage = leng;
	}

}
