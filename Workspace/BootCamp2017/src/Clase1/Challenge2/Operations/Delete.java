package Clase1.Challenge2.Operations;

import Clase1.Challenge2.Database;
import Clase1.Challenge2.Result;

public class Delete extends Operation{

	public Delete(String columns, String fromTable, String conditions) {
		super(columns, fromTable, conditions);
	}

	@Override
	public String getQuery() {
		return "DELETE FROM " + this.fromTable + " WHERE " + this.conditions;
	}
	
	

}
