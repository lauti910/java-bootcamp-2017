package Clase1.Challenge2.Operations;

import Clase1.Challenge2.Database;
import Clase1.Challenge2.Result;

public class Select extends Operation{

	public Select(String columns, String fromTable, String conditions) {
		super(columns, fromTable, conditions);
	}
	
	@Override
	public String getQuery() {
		return "SELECT " + this.columns + " FROM " + this.fromTable + " WHERE " + this.conditions;
	}

	

}
