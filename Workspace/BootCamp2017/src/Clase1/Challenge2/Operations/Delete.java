package Clase1.Challenge2.Operations;


public class Delete extends Operation{

	public Delete(String columns, String fromTable, String conditions) {
		super(columns, fromTable, conditions);
	}

	@Override
	public String getQuery() {
		return "DELETE FROM " + this.fromTable + " WHERE " + this.conditions;
	}
	
	

}
