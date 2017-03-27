package Clase1.Challenge2.Operations;

public class Update extends Operation{

	public Update(String columns, String fromTable, String conditions) {
		super(columns, fromTable, conditions);
	}

	@Override
	public String getQuery() {
		return "UPDATE " + this.fromTable + " SET " + this.columns + " WHERE " + this.conditions;
	}

}
