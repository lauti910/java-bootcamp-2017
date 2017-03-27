package bootcamp.java2017.Clase1.Challenge2;

import bootcamp.java2017.Clase1.Challenge2.Operations.Operation;

public class Database {
	
	
	public Result executeOperation(Operation op){
		
		return op.execute(this);
	}

	public Result executeQuery(String string) {
		//executes the query in the database, and returns its result
		return null;
		
	}
}
