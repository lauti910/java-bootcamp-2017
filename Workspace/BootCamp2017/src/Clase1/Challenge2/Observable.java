package Clase1.Challenge2;

public interface Observable{
	
	public void addObserver(OperationObserver observer);
	public void removeObserver(OperationObserver observer);
	public void notifyObservers();
	
}
