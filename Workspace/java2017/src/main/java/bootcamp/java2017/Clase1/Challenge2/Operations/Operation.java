package bootcamp.java2017.Clase1.Challenge2.Operations;


import java.util.ArrayList;
import java.util.List;

import bootcamp.java2017.Clase1.Challenge2.Database;
import bootcamp.java2017.Clase1.Challenge2.Observable;
import bootcamp.java2017.Clase1.Challenge2.OperationObserver;
import bootcamp.java2017.Clase1.Challenge2.Result;

public abstract class Operation implements Observable{
	protected String columns;
	protected String fromTable;
	protected String conditions;
	private List<OperationObserver> observers;
	
	public Operation(String columns, String fromTable, String conditions) {
		this.columns = columns;
		this.fromTable = fromTable;
		this.conditions = conditions;
		this.observers = new ArrayList<OperationObserver>();
	}

	public abstract String getQuery();
	
	
	public Result execute(Database db){

		Result res = db.executeQuery(this.getQuery());
		this.notifyObservers();
		return res;
	}
	
	public void addObserver(OperationObserver observer){
		observers.add(observer);
	}
	public void removeObserver(OperationObserver observer){
		observers.remove(observer);
	}
	public void notifyObservers(){
		observers.forEach(obs -> obs.update(this));
	}
	
}
