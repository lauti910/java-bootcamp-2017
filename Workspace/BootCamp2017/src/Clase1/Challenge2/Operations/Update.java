package Clase1.Challenge2.Operations;

import Clase1.Challenge2.Database;
import Clase1.Challenge2.Result;

public class Update extends Operation{

	public Update(String columns, String fromTable, String conditions) {
		super(columns, fromTable, conditions);
	}

	@Override
	public String getQuery() {
		return "UPDATE " + this.fromTable + " SET " + this.columns + " WHERE " + this.conditions;
	}

}
