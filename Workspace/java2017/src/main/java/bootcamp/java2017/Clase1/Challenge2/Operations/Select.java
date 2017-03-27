package bootcamp.java2017.Clase1.Challenge2.Operations;


public class Select extends Operation{

	public Select(String columns, String fromTable, String conditions) {
		super(columns, fromTable, conditions);
	}
	
	@Override
	public String getQuery() {
		return "SELECT " + this.columns + " FROM " + this.fromTable + " WHERE " + this.conditions;
	}

	

}
