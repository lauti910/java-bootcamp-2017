package Clase1.Challenge2.Lenguages;

public class EnglishLogger implements LoggerLenguage{

	@Override
	public void log(String logMessage) {
		System.out.println("Executed "+ logMessage);
	}

}
