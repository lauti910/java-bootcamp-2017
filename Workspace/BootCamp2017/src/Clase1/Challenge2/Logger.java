package Clase1.Challenge2;

import Clase1.Challenge2.Operations.Operation;

public class Logger implements OperationObserver{

	@Override
	public void update(Operation operation) {
		
		System.out.println("Executed " + operation.getQuery());
		
	}

}
