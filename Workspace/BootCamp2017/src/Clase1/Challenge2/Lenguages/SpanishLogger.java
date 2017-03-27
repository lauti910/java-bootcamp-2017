package Clase1.Challenge2.Lenguages;

public class SpanishLogger implements LoggerLenguage{

	@Override
	public void log(String logMessage) {
		System.out.println("Se ejecuto " + logMessage);
	}

}
